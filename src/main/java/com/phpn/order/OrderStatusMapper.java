package com.phpn.mappers.order;

import com.phpn.dto.orderStatus.OrderStatusResult;
import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.order.OrderStatus;

@Component
public class OrderStatusMapper {
    public OrderStatusResult toDTO(OrderStatus orderStatus) {
        return new OrderStatusResult()
                .setName(orderStatus.getName());
    }
}
