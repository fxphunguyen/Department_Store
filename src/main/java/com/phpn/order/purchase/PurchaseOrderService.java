package com.phpn.payment;

import com.phpn.dto.purchase_order.PurchaseOrderCreate;
import com.phpn.dto.purchase_order.PurchaseOrderResult;
import vn.fx.qh.sapo.entities.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {

    List<PurchaseOrderResult> findAll();

    PurchaseOrder create(PurchaseOrderCreate purchaseOrderCreate);
}
