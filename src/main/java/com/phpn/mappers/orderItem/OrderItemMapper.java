package com.phpn.mappers.orderItem;

import com.phpn.dto.orderItem.OrderItemParam;
import com.phpn.dto.orderItem.OrderItemResult;
import com.phpn.repositories.model.Order;
import com.phpn.repositories.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {
    public OrderItemResult toDTO(OrderItem orderItem) {

        return new OrderItemResult()
                .setId(orderItem.getId())
                .setTotal(orderItem.getTotal())
                .setQuantity(orderItem.getQuantity())
                .setCreateAt(orderItem.getCreateAt());

    }

    public OrderItem toModel(OrderItemParam orderItemParam) {
        return new OrderItem()
                .setItemId(orderItemParam.getId())
                .setTotal(orderItemParam.getTotal())
                .setQuantity(orderItemParam.getQuantity());
    }
}
