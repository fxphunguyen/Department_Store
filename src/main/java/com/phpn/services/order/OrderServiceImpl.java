package com.phpn.services.order;

import com.phpn.dto.order.OrderParam;
import com.phpn.dto.order.OrderResult;
import com.phpn.dto.orderItem.OrderItemExport;
import com.phpn.dto.orderItem.OrderItemParam;
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
import java.util.zip.DataFormatException;


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
        BigDecimal tax;
        BigDecimal total = BigDecimal.valueOf(0);
        BigDecimal grandTotal = BigDecimal.valueOf(0);
        for (OrderItemExport itemExport : orderParam.getOrderItems()) {
            if (!productRepository.existsById(itemExport.getProductId())) {
                throw new NotFoundException("Không tìm thấy Id sản phẩm " + itemExport.getProductId());
            }
            //lấy toàn bộ item theo productId
            List<Item> items = itemRepository.findAllByProductIdAndAvailableGreaterThanOrderByCreateAt(itemExport.getProductId(), 0);
            int totalAvailable = items.stream().mapToInt(Item::getAvailable).sum();
            if (totalAvailable < itemExport.getQuantity()) {
                throw new NotEnoughQuantityException("Không đủ số lượng cho đơn hàng, vui lòng kiểm tra lại !");
            }
            int productId = itemExport.getProductId();

            Optional<Product> productOptional = productRepository.findById(productId);

            BigDecimal retailPrice = (productOptional.get().getRetailPrice());

            int quantityCustomerOrder = itemExport.getQuantity();
            System.out.println(quantityCustomerOrder);

            BigDecimal totalOrderItem = retailPrice.multiply(new BigDecimal(quantityCustomerOrder));

            total = total.add(retailPrice.multiply(new BigDecimal(quantityCustomerOrder)));
            order.setTotal(total);

            tax = total.multiply(new BigDecimal(0.1));
            order.setTax(tax);

            grandTotal = total.add(tax);
            order.setGrandTotal(grandTotal);


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
                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(orderItemSold);
                orderItem.setPrice(retailPrice);
                orderItem.setProductId(productId);
                orderItem.setItemId(item.getId());
                orderItem.setOrderId(order.getId());

                orderItemRepository.save(orderItem);
            }
        }
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
