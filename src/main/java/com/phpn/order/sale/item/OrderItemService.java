package com.phpn.order.sale.item;

import com.phpn.order.sale.dto.SaleOrderItemResult;

import java.util.List;

public interface OrderItemService {

    List<SaleOrderItemResult> findAll();

    List<SaleOrderItemResult> findAllOrderItemByOrderId(Integer orderId);

}
