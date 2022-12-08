package com.phpn.order.purchase.dto;

import com.phpn.supplier.SupplierMapper;
import com.phpn.employee.dto.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.order.purchase.*;

@Component
public class PurchaseOrderMapper {

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public PurchaseOrder toModel(PurchaseOrderParam purchaseOrderParam) {
        return new PurchaseOrder();
//                .setId(purchaseOrderParam.getId())
//                .setPurchaseOrderCode(purchaseOrderParam.getPurchaseCode())
//                .setPurchaseOrderItemId(purchaseOrderParam.getPurchaseOrderItemId())
//                .setEmployeeId(purchaseOrderParam.getEmployeeId())
//                .setSupplierId(purchaseOrderParam.getSupplierId())
//                .setStatus(purchaseOrderParam.getStatus());
    }

    public PurchaseOrderResult toDTO(PurchaseOrder purchaseOrder) {
        return new PurchaseOrderResult();
//                .setPurchaseOrderCode(purchaseOrder.getPurchaseOrderCode())
//                .setEmployeeResult(employeeMapper.toDTO(purchaseOrder.getEmployee()))
//                .setEmployeeId(purchaseOrder.getEmployeeId())
//                .setSupplierId(purchaseOrder.getSupplierId())
//                .setSupplierResult(supplierMapper.toDTO(purchaseOrder.getSupplier()))
//                .setStatus(purchaseOrder.getStatus())
//                .setGrandTotal(purchaseOrder.getGrandTotal());
    }

}
