package com.phpn.services.order;

import com.phpn.dto.order.OrderParam;
import com.phpn.dto.order.OrderResult;

import java.util.List;

public interface OrderService {

    List<OrderResult> findAll();

    OrderResult createOrderExport(OrderParam orderParam);

}
