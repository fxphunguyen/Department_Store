package com.phpn.mappers;

import com.phpn.dto.purchase_order_item.PurchaseOrderItemParam;
import com.phpn.dto.purchase_order_item.PurchaseOrderItemResult;
import com.phpn.repositories.model.PurchaseOrderItem;
import org.springframework.stereotype.Component;

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
