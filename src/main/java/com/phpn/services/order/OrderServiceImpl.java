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
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
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
    @Transactional(readOnly = true)
    public List<OrderResult> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrderResult createOrderExport(OrderParam orderParam) {
        Random rand = new Random();
        int ranNum = rand.nextInt(100000)+1;

//        Integer employeeId = orderParam.getEmployeeId();
        Integer customerId = orderParam.getCustomerId();
        if (customerId == null && !customerRepository.existsById(customerId))
            throw new NotFoundException("Không tìm thấy khách hàng");

        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Optional<Employee> employeeOptional = employeeRepository.findById(orderParam.getEmployeeId());


        Order order = orderMapper.toModel(orderParam);
        order.setGrandTotal(new BigDecimal(0));
        order.setTotal(new BigDecimal(0));
        order.setOrderCode("SON00"+String.valueOf(ranNum));
        order.setCreateAt(Instant.now());
        order.setSubTotal(new BigDecimal(0));
        order.setCustomer(customerOptional.get());
        order.setEmployee(employeeOptional.get());
        order = orderRepository.save(order);
        BigDecimal total = BigDecimal.valueOf(0);
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
                BigDecimal amountTax = (orderItemTotal.multiply(BigDecimal.valueOf(taxTotal / 100)));
                orderItemTotal = orderItemTotal.add(amountTax);
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
        order.setSubTotal(subTotal);
        //cong them phi giao hang
        total = subTotal.add(BigDecimal.valueOf(0));
        order.setTotal(total);
        if (order.getDiscount() != null) {
            grandTotal = total.subtract(order.getDiscount());
        } else {
            grandTotal = total;
        }
        //tru ma giam gia
        order.setGrandTotal(grandTotal);
        return orderMapper.toDTO(order);


    }

    @Override
    @Transactional
    public OrderResult findById(int id) {
        Optional<Order> optional = orderRepository.findById(id);
        if (!optional.isPresent())
            throw new NotFoundException("Đơn hàng không hợp lệ!");
        OrderResult result = orderMapper.toDTO(optional.get());
        List<OrderItemResult> orderItems = orderItemRepository.findAllByOrderId(result.getId())
                .stream()
                .map(orderItemMapper::toDTO)
                .collect(Collectors.toList());
        result.setOrderItems(orderItems);

        return result;
    }


}
