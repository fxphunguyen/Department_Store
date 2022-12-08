package com.phpn.order.sale;

import com.phpn.order.sale.dto.OrderItemResult;

import java.util.List;

public interface OrderItemService {

    List<OrderItemResult> findAll();

    List<OrderItemResult> findAllOrderItemByOrderId(Integer orderId);

}
