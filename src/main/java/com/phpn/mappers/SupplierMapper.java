package com.phpn.mappers;

import org.jetbrains.annotations.NotNull;

import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.mappers.localtionRegion.LocationRegionMapper;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.phpn.dto.suppliers.SupplierParam;
import com.phpn.dto.suppliers.SupplierResult;
import com.phpn.dto.suppliers.SupplierCreateParam;
import com.phpn.dto.suppliers.SupplierUpdateParam;
import com.phpn.repositories.model.Supplier;

@Component
public class SupplierMapper {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private LocationRegionMapper locationRegionMapper;

    public SupplierResult toDTO(@NotNull Supplier supplier) {
        return new SupplierResult()
        .setId(supplier.getId())
        .setSupplierCode(supplier.getSupplierCode())
        .setName(supplier.getName())
        .setEmail(supplier.getEmail())
        .setPhone(supplier.getPhone())
        .setSupplierStatus(supplier.getStatus())
        .setDescription(supplier.getDescription())
        .setEmployeeId(supplier.getEmployeeId())
        .setLocationRegionId(supplier.getLocationRegionId())
        .setEmployeeResult(employeeMapper.toDTO(supplier.getEmployee()))
        .setLocationRegionResult(locationRegionMapper.toDTO(supplier.getLocationRegion()))
        .setCreateAt(supplier.getCreateAt())
        .setUpdateAt(supplier.getUpdateAt());
    }

    public Supplier toModel(@NotNull SupplierResult supplierResult) {
        return new Supplier(supplierResult.getEmployeeId(), supplierResult.getLocationRegionId())
        .setId(supplierResult.getId())
        .setSupplierCode(supplierResult.getSupplierCode())
        .setName(supplierResult.getName())
        .setEmail(supplierResult.getEmail())
        .setPhone(supplierResult.getPhone())
        .setStatus(supplierResult.getSupplierStatus())
        .setDescription(supplierResult.getDescription())
        .setEmployeeId(supplierResult.getEmployeeId())
        .setLocationRegionId(supplierResult.getLocationRegionId())
        .setCreateAt(supplierResult.getCreateAt())
        .setUpdateAt(supplierResult.getUpdateAt());
    }

    public Supplier toModel(@NotNull SupplierParam supplierParam) {
        return new Supplier(supplierParam.getEmployeeId(), supplierParam.getLocationRegionId())
        .setId(supplierParam.getId())
        .setSupplierCode(supplierParam.getSupplierCode())
        .setName(supplierParam.getName())
        .setEmail(supplierParam.getEmail())
        .setPhone(supplierParam.getPhone())
        .setStatus(supplierParam.getSupplierStatus())
        .setDescription(supplierParam.getDescription())
        .setEmployeeId(supplierParam.getEmployeeId())
        .setLocationRegionId(supplierParam.getLocationRegionId())
        .setCreateAt(supplierParam.getCreateAt())
        .setUpdateAt(supplierParam.getUpdateAt());
    }

    public Supplier toModel(@NotNull SupplierCreateParam supplierCreateParam) {
        return new Supplier(supplierCreateParam.getEmployeeId(), supplierCreateParam.getLocationRegionId())
        .setSupplierCode(supplierCreateParam.getSupplierCode())
        .setName(supplierCreateParam.getName())
        .setEmail(supplierCreateParam.getEmail())
        .setPhone(supplierCreateParam.getPhone())
        .setStatus(supplierCreateParam.getSupplierStatus())
        .setDescription(supplierCreateParam.getDescription())
        .setEmployeeId(supplierCreateParam.getEmployeeId())
        .setLocationRegionId(supplierCreateParam.getLocationRegionId())
        .setCreateAt(supplierCreateParam.getCreateAt())
        .setUpdateAt(supplierCreateParam.getUpdateAt());
    }

    public Supplier toModel(@NotNull SupplierUpdateParam supplierUpdateParam) {
        return new Supplier(supplierUpdateParam.getEmployeeId(), supplierUpdateParam.getLocationRegionId())
        .setSupplierCode(supplierUpdateParam.getSupplierCode())
        .setName(supplierUpdateParam.getName())
        .setEmail(supplierUpdateParam.getEmail())
        .setPhone(supplierUpdateParam.getPhone())
        .setStatus(supplierUpdateParam.getSupplierStatus())
        .setDescription(supplierUpdateParam.getDescription())
        .setEmployeeId(supplierUpdateParam.getEmployeeId())
        .setLocationRegionId(supplierUpdateParam.getLocationRegionId())
        .setCreateAt(supplierUpdateParam.getCreateAt())
        .setUpdateAt(supplierUpdateParam.getUpdateAt());
    }

}