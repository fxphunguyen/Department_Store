package com.phpn.services.order_item;

import com.phpn.dto.order.OrderResult;
import com.phpn.dto.orderItem.OrderItemParam;
import com.phpn.dto.orderItem.OrderItemResult;

import java.util.List;

public interface OrderItemService {

    List<OrderItemResult> findAll();

    OrderItemResult createOrderItem(OrderItemParam orderItemParam);

}
