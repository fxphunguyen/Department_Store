package com.phpn.services.order;

import com.phpn.dto.order.OrderResult;
import com.phpn.dto.orderItem.OrderItemResult;
import com.phpn.exceptions.NotFoundException;
import com.phpn.mappers.order.OrderMapper;
import com.phpn.mappers.orderItem.OrderItemMapper;
import com.phpn.repositories.OrderItemRepository;
import com.phpn.repositories.OrderRepository;
import com.phpn.repositories.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
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

    @Override
    @Transactional
    public List<OrderResult> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
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
