package com.phpn.services.order;

import com.phpn.dto.order.OrderParam;
import com.phpn.dto.order.OrderResult;
import com.phpn.dto.orderItem.OrderItemExport;
import com.phpn.dto.orderItem.OrderItemResult;
import com.phpn.exceptions.NotEnoughQuantityException;
import com.phpn.exceptions.NotFoundException;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.mappers.order.OrderMapper;
import com.phpn.mappers.orderItem.OrderItemMapper;
import com.phpn.repositories.*;
import com.phpn.repositories.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private ProductTaxRepository productTaxRepository;

    @Override
    @Transactional
    public List<OrderResult> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrderResult createOrderExport(OrderParam orderParam) {

//        Integer employeeId = orderParam.getEmployeeId();
        Integer customerId = orderParam.getCustomerId();
        if (customerId != null && !customerRepository.existsById(customerId))
            throw new NotFoundException("Không tìm thấy khách hàng");
        Order order = orderMapper.toModel(orderParam);
        order.setGrandTotal(new BigDecimal(0));
        order.setTotal(new BigDecimal(0));
        order.setOrderCode("SF001");
        order = orderRepository.save(order);
        BigDecimal subTotal = BigDecimal.valueOf(0);
        BigDecimal grandTotal = BigDecimal.valueOf(0);
        for (OrderItemExport orderItemExport : orderParam.getOrderItems()) {

            Optional<Product> productOptional = productRepository.findById(orderItemExport.getProductId());

            if (!productOptional.isPresent()) {
                throw new NotFoundException("Không tìm thấy Id sản phẩm " + orderItemExport.getProductId());
            }
            //lấy toàn bộ item theo productId
            List<Item> items = itemRepository.findAllByProductIdAndAvailableGreaterThanOrderByCreateAt(orderItemExport.getProductId(), 0);
            int totalAvailable = items.stream().mapToInt(Item::getAvailable).sum();
            if (totalAvailable < orderItemExport.getQuantity()) {
                throw new NotEnoughQuantityException("Không đủ số lượng cho đơn hàng, vui lòng kiểm tra lại !");
            }
            Product product = productOptional.get();
            Integer productId = product.getId();
            BigDecimal retailPrice = product.getRetailPrice();

            int quantityCustomerOrder = orderItemExport.getQuantity();
            BigDecimal orderItemTotal = retailPrice.multiply(new BigDecimal(quantityCustomerOrder));

            OrderItem orderItem = new OrderItem();
            if (product.getApplyTax()) {
                List<ProductTax> productTaxList = productTaxRepository.findAllByProductIdAndTaxType(productId, TaxType.OUT);
                float taxTotal = (float) productTaxList.stream()
                        .mapToDouble(productTax -> productTax.getId().getTax().getTax()).sum();
                orderItem.setTax(taxTotal);
                orderItemTotal = orderItemTotal.multiply(BigDecimal.valueOf(taxTotal / 100));
            }

            if (orderItem.getDiscount() != null) {
                orderItemTotal = orderItemTotal.subtract(orderParam.getDiscount());
            }

            subTotal = subTotal.add(orderItemTotal);

            for (Item item : items) {
                if (quantityCustomerOrder == 0) {
                    break;
                }
                int available = item.getAvailable();
                int orderItemSold;
                if (quantityCustomerOrder >= available) {
                    quantityCustomerOrder = quantityCustomerOrder - available;
                    item.setAvailable(0);
                    orderItemSold = available;
                    int itemSold = item.getSold() + available;
                    item.setSold(itemSold);
                } else {
                    available = available - quantityCustomerOrder;
                    item.setAvailable(available);
                    orderItemSold = quantityCustomerOrder;
                    int itemSold = item.getSold() + quantityCustomerOrder;
                    item.setSold(itemSold);
                    quantityCustomerOrder = 0;
                }

                orderItem.setQuantity(orderItemSold);
                orderItem.setPrice(retailPrice);
                orderItem.setProductId(productId);
                orderItem.setItemId(item.getId());
                orderItem.setOrderId(order.getId());


                orderItemRepository.save(orderItem);
            }
        }
       // order.setSubTotal(total);
        //cong them phi giao hang
        BigDecimal total = subTotal.add(BigDecimal.valueOf(0));
        order.setTotal(total);

        //tru ma giam gia
        order.setGrandTotal(grandTotal);
        return orderMapper.toDTO(order);


    }

    @Transactional
    public OrderResult findById(int id) {
        Optional<Order> optional = orderRepository.findById(id);
        if (!optional.isPresent())
            throw new NotFoundException("order id not invalid");
        OrderResult result = orderMapper.toDTO(optional.get());
        List<OrderItemResult> orderItems = orderItemRepository.findAllByOrderId(result.getId())
                .stream()
                .map(orderItemMapper::toDTO)
                .collect(Collectors.toList());
        result.setOrderItems(orderItems);
        return result;
    }


}
