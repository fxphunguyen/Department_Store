package com.phpn.mappers;

import java.time.LocalDateTime;
import org.jetbrains.annotations.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.mappers.localtionRegion.LocationRegionMapper;
import com.phpn.dto.suppliers.SupplierParam;
import com.phpn.dto.suppliers.SupplierResult;
import com.phpn.dto.suppliers.SupplierCreate;
import com.phpn.dto.suppliers.SupplierUpdate;
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
        .setEmployeeResult(employeeMapper.toDTO(supplier.getEmployee()))
        .setLocationRegionId(supplier.getLocationRegionId())
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

    public Supplier toModel(@NotNull SupplierCreate supplierCreate) {
        return new Supplier(supplierCreate.getEmployeeId(), supplierCreate.getLocationRegionId())
        .setSupplierCode(supplierCreate.getSupplierCode())
        .setName(supplierCreate.getName())
        .setEmail(supplierCreate.getEmail())
        .setPhone(supplierCreate.getPhone())
        .setStatus(supplierCreate.getSupplierStatus())
        .setDescription(supplierCreate.getDescription())
        .setEmployeeId(supplierCreate.getEmployeeId())
        .setLocationRegionId(supplierCreate.getLocationRegionId())
        .setCreateAt(LocalDateTime.now().toString())
        .setUpdateAt(LocalDateTime.now().toString());
    }

    public Supplier toModel(@NotNull SupplierUpdate supplierUpdate) {
        return new Supplier(supplierUpdate.getEmployeeId(), supplierUpdate.getLocationRegionId())
        .setId(supplierUpdate.getId())
        .setSupplierCode(supplierUpdate.getSupplierCode())
        .setName(supplierUpdate.getName())
        .setEmail(supplierUpdate.getEmail())
        .setPhone(supplierUpdate.getPhone())
        .setStatus(supplierUpdate.getSupplierStatus())
        .setDescription(supplierUpdate.getDescription())
        .setEmployeeId(supplierUpdate.getEmployeeId())
        .setLocationRegionId(supplierUpdate.getLocationRegionId())
        .setCreateAt(supplierUpdate.getCreateAt())
        .setUpdateAt(LocalDateTime.now().toString());
    }

}