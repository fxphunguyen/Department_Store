package com.phpn.mappers;

import com.phpn.dto.orderStatus.OrderStatusResult;
import com.phpn.repositories.model.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusMapper {

    public OrderStatusResult toDTO(OrderStatus orderStatus) {
        return new OrderStatusResult()
                .setName(orderStatus.getName());
    }
}
