package com.phpn.services.order;

import com.phpn.dto.order.OrderResult;
import com.phpn.dto.purchase_order.PurchaseOrderCreate;
import com.phpn.dto.purchase_order.PurchaseOrderResult;
import com.phpn.repositories.model.PurchaseOrder;

import java.util.List;

public interface OrderService {

    List<OrderResult> findAll();

}
