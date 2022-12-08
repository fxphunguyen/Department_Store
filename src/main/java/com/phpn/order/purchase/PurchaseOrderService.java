package com.phpn.order.purchase;


import com.phpn.order.purchase.dto.CreatePurchaseOrderParam;
import com.phpn.order.purchase.dto.PurchaseOrderResult;

import java.util.List;

public interface PurchaseOrderService {

    List<PurchaseOrderResult> findAll();

    PurchaseOrderResult create(CreatePurchaseOrderParam createPurchaseOrder);
}
