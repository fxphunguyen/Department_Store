package com.phpn.services.purchaseOrderItem;

import com.phpn.dto.purchase_order_item.PurchaseOrderItemParam;
import com.phpn.dto.purchase_order_item.PurchaseOrderItemResult;
import com.phpn.mappers.PurchaseOrderItemMapper;
import com.phpn.repositories.model.PurchaseOrderItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PurchaseOrderItemImpl implements PurchaseOrderItemService {

    @Autowired
    PurchaseOrderItemMapper purchaseOrderItemMapper;

    @Override
    public PurchaseOrderItem create(PurchaseOrderItemParam purchaseOrderItemParam) {
        return null;
    }

    @Override
    public List<PurchaseOrderItemResult> findAllByPurchaseOrderId(Integer id) {
        return null;
    }

    @Override
    public List<PurchaseOrderItemResult> findAll() {
        return null;
    }
}