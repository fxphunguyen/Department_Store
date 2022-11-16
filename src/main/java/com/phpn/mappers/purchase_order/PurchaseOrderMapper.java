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
                .setPurchaseOrderItemId(purchaseOrderParam.getPurchaseOrderItemId())
                .setEmployeeId(purchaseOrderParam.getEmployeeId())
                .setSupplierId(purchaseOrderParam.getSupplierId())
                .setPaymentMethodId(purchaseOrderParam.getPaymentMethodId())
                .setStatus(purchaseOrderParam.getStatus())
                .setPays(purchaseOrderParam.getPays());
    }

    public PurchaseOrderResult toDTO(PurchaseOrder purchaseOrder) {
        return new PurchaseOrderResult()
                .setId(purchaseOrder.getId())
                .setPurchaseCode(purchaseOrder.getPurchaseOrderCode())
                .setEmployeeId(purchaseOrder.getEmployeeId())
                .setSupplierId(purchaseOrder.getSupplierId())
                .setPaymentMethodId(purchaseOrder.getPaymentMethodId())
                .setPays(purchaseOrder.getPays())
                .setStatus(purchaseOrder.getStatus())
                .setGrandTotal(purchaseOrder.getGrandTotal());
    }

}
