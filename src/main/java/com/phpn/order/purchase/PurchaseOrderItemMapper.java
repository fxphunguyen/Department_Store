package com.phpn.order.purchase;

import com.phpn.order.purchase.dto.PurchaseOrderItemParam;
import com.phpn.order.purchase.dto.PurchaseOrderItemResult;
import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.order.purchase.PurchaseOrderItem;

@Component
public class PurchaseOrderItemMapper {

    public PurchaseOrderItemResult toDTO(PurchaseOrderItem purchaseOrderItem) {
        return new PurchaseOrderItemResult()
                .setId(purchaseOrderItem.getId())
                .setItemId(purchaseOrderItem.getItemId())
                .setPurchaseOrderId(purchaseOrderItem.getPurchaseOrderId())
                .setPrice(purchaseOrderItem.getPrice())
                .setProductId(purchaseOrderItem.getProductId())
                .setQuantity(purchaseOrderItem.getQuantity());
    }

    public PurchaseOrderItem toModel(PurchaseOrderItemParam purchaseOrderItemParam) {
        return new PurchaseOrderItem()
                .setItemId(purchaseOrderItemParam.getItemId())
                .setPurchaseOrderId(purchaseOrderItemParam.getPurchaseOrderId())
                .setProductId(purchaseOrderItemParam.getProductId());
    }
}
