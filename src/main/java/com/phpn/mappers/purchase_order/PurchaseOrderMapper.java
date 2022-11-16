package com.phpn.mappers.purchase_order;

import com.phpn.dto.purchase_order.PurchaseOrderParam;
import com.phpn.dto.purchase_order.PurchaseOrderResult;
import com.phpn.repositories.model.PurchaseOrder;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderMapper {

    public PurchaseOrder toModel(PurchaseOrderParam purchaseOrderParam) {
        return new PurchaseOrder()
                .setId(purchaseOrderParam.getId())
                .setPurchaseOrderCode(purchaseOrderParam.getPurchaseCode())
                .setProductId(purchaseOrderParam.getProductId())
                .setEmployeeId(purchaseOrderParam.getEmployeeId())
                .setSupplierId(purchaseOrderParam.getSupplierId())
                .setPaymentMethodId(purchaseOrderParam.getPaymentMethodId())
                .setStatus(purchaseOrderParam.getStatus());
    }

    public PurchaseOrderResult toDTO(PurchaseOrder purchaseOrder) {
        return new PurchaseOrderResult()
                .setId(purchaseOrder.getId())
                .setPurchaseCode(purchaseOrder.getPurchaseOrderCode())
                .setProductId(purchaseOrder.getProductId())
                .setEmployeeId(purchaseOrder.getEmployeeId())
                .setSupplierId(purchaseOrder.getSupplierId())
                .setPaymentMethodId(purchaseOrder.getPaymentMethodId())
                .setStatus(purchaseOrder.getStatus());
    }

}
