package com.phpn.mappers.purchase_order;

import com.phpn.dto.purchase_order.PurchaseOrderParam;
import com.phpn.dto.purchase_order.PurchaseOrderResult;
import com.phpn.mappers.SupplierMapper;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.repositories.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderMapper {

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public PurchaseOrder toModel(PurchaseOrderParam purchaseOrderParam) {
        return new PurchaseOrder()
                .setId(purchaseOrderParam.getId())
                .setPurchaseOrderCode(purchaseOrderParam.getPurchaseCode())
                .setPurchaseOrderItemId(purchaseOrderParam.getPurchaseOrderItemId())
                .setEmployeeId(purchaseOrderParam.getEmployeeId())
                .setSupplierId(purchaseOrderParam.getSupplierId())
                .setStatus(purchaseOrderParam.getStatus());
    }

    public PurchaseOrderResult toDTO(PurchaseOrder purchaseOrder) {
        return new PurchaseOrderResult()
                .setPurchaseOrderCode(purchaseOrder.getPurchaseOrderCode())
                .setEmployeeResult(employeeMapper.toDTO(purchaseOrder.getEmployee()))
                .setEmployeeId(purchaseOrder.getEmployeeId())
                .setSupplierId(purchaseOrder.getSupplierId())
                .setSupplierResult(supplierMapper.toDTO(purchaseOrder.getSupplier()))
                .setStatus(purchaseOrder.getStatus())
                .setGrandTotal(purchaseOrder.getGrandTotal());
    }

}
