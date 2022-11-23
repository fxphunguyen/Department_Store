package com.phpn.services.purchaseOrderItem;

import com.phpn.dto.purchase_order_item.PurchaseOrderItemParam;
import com.phpn.dto.purchase_order_item.PurchaseOrderItemResult;
import com.phpn.repositories.model.PurchaseOrderItem;

import java.util.List;

public interface PurchaseOrderItemService {

    PurchaseOrderItem create(PurchaseOrderItemParam purchaseOrderItemParam);

    List<PurchaseOrderItemResult> findAllByPurchaseOrderId (Integer id);

    List<PurchaseOrderItemResult> findAll();
}
