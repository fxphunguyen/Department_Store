package com.phpn.supplier;

import com.phpn.employee.dto.EmployeeMapper;
import com.phpn.payment.method.PaymentMethodMapper;
import vn.fx.qh.sapo.entities.product.supplier.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;

@Component
public class SupplierMapper {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private PaymentMethodMapper paymentMethodMapper;

    public SupplierResult toDTO(Supplier supplier) {
        return new SupplierResult()
        .setId(supplier.getId())
        .setSupplierCode(supplier.getSupplierCode())
        .setName(supplier.getName())
        .setEmail(supplier.getEmail())
        .setPhone(supplier.getPhone())
        .setStatus(supplier.getStatus())
        .setDescription(supplier.getDescription())
        .setEmployeeId(supplier.getEmployeeId())
        .setEmployee(employeeMapper.toDTO(supplier.getEmployee()))
        .setPaymentMethodId(supplier.getPaymentMethodId())
        .setPaymentMethod(paymentMethodMapper.toDTO(supplier.getPaymentMethod()))

    }

    public Supplier toModel(SupplierResult supplierResult) {
        return new Supplier(supplierResult.getEmployeeId(), supplierResult.getPaymentMethodId())
        .setId(supplierResult.getId())
        .setSupplierCode(supplierResult.getSupplierCode())
        .setName(supplierResult.getName())
        .setEmail(supplierResult.getEmail())
        .setPhone(supplierResult.getPhone())
        .setStatus(supplierResult.getStatus())
        .setDescription(supplierResult.getDescription())
        .setEmployeeId(supplierResult.getEmployeeId())
        .setPaymentMethodId(supplierResult.getPaymentMethodId())


    }

    public Supplier toModel(SupplierParam supplierParam) {
        return new Supplier(supplierParam.getEmployeeId(), supplierParam.getPaymentMethodId())
        .setId(supplierParam.getId())
        .setSupplierCode(supplierParam.getSupplierCode())
        .setName(supplierParam.getName())
        .setEmail(supplierParam.getEmail())
        .setPhone(supplierParam.getPhone())
        .setStatus(supplierParam.getSupplierStatus())
        .setDescription(supplierParam.getDescription())
        .setEmployeeId(supplierParam.getEmployeeId())
        .setPaymentMethodId(supplierParam.getPaymentMethodId());
    }

    public Supplier toModel(SupplierCreate supplierCreate) {
        return new Supplier(supplierCreate.getEmployeeId(), supplierCreate.getPaymentMethodId())
        .setSupplierCode(supplierCreate.getSupplierCode())
        .setName(supplierCreate.getName())
        .setEmail(supplierCreate.getEmail())
        .setPhone(supplierCreate.getPhone())
        .setDescription(supplierCreate.getDescription())
        .setEmployeeId(supplierCreate.getEmployeeId())
        .setPaymentMethodId(supplierCreate.getPaymentMethodId())


    }

}