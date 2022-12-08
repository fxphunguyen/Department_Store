package com.phpn.order;

import com.phpn.order.sale.dto.SaleOrderStatusResult;
import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.order.OrderStatus;

@Component
public class OrderStatusMapper {
    public SaleOrderStatusResult toDTO(OrderStatus orderStatus) {
        return new SaleOrderStatusResult()
                .setName(orderStatus.getName());
    }
}
