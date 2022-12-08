package com.phpn.order;

import com.phpn.order.PurchaseOrderItemParam;
import com.phpn.order.PurchaseOrderItemResult;
import vn.fx.qh.sapo.entities.PurchaseOrderItem;

import java.util.List;

public interface PurchaseOrderItemService {

    PurchaseOrderItem create(PurchaseOrderItemParam purchaseOrderItemParam);

    List<PurchaseOrderItemResult> findAllByPurchaseOrderId (Integer id);

    List<PurchaseOrderItemResult> findAll();
}
