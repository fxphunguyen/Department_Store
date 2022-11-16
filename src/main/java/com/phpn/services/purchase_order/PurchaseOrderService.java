package com.phpn.services.purchase_order;

import com.phpn.dto.purchase_order.PurchaseOrderCreate;
import com.phpn.dto.purchase_order.PurchaseOrderResult;
import com.phpn.repositories.model.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {

    List<PurchaseOrderResult> findAll();

    PurchaseOrder create(PurchaseOrderCreate purchaseOrderCreate);
}
