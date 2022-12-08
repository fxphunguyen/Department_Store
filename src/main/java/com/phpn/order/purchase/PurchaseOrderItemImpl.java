package com.phpn.order;

import vn.fx.qh.sapo.entities.PurchaseOrderItem;
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