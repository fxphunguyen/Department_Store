package com.phpn.mappers;

import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.repositories.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.phpn.dto.supplier.SupplierParam;
import com.phpn.dto.supplier.SupplierResult;
import com.phpn.dto.supplier.SupplierCreateParam;
import com.phpn.dto.supplier.SupplierUpdateParam;
import com.phpn.repositories.model.Supplier;

@Component
public class SupplierMapper {

    @Autowired
    EmployeeMapper employeeMapper;



    public SupplierResult toDTO(Supplier supplier) {
//        System.out.println(supplier);
        return new SupplierResult()
        .setId(supplier.getId())
        .setSupplierCode(supplier.getSupplierCode())
        .setName(supplier.getName())
        .setEmail(supplier.getEmail())
        .setPhone(supplier.getPhone())
        .setStatus(supplier.getStatus())
        .setDescription(supplier.getDescription())
        .setEmployee(supplier.setEmployeeId(supplier.getEmployeeId()).getEmployee())
//        .setLocationRegion(supplier.getLocationRegion())
        .setEmployeeName(supplier.setEmployeeId(supplier.getEmployeeId()).getEmployee().getName())
        .setUpdateAt(supplier.getUpdateAt());
    }

    public Supplier toModel(SupplierResult supplierResult) {
        System.out.println(supplierResult);
        return new Supplier(supplierResult.getEmployeeId(), supplierResult.getLocationRegionId())
        .setId(supplierResult.getId())
        .setSupplierCode(supplierResult.getSupplierCode())
        .setName(supplierResult.getName())
        .setEmail(supplierResult.getEmail())
        .setPhone(supplierResult.getPhone())
        .setStatus(supplierResult.getStatus())
        .setDescription(supplierResult.getDescription())
        .setEmployee(supplierResult.getEmployee())
        .setLocationRegion(supplierResult.getLocationRegion());
    }

    public Supplier toModel(SupplierParam supplierParam) {
        return new Supplier(supplierParam.getEmployeeId(), supplierParam.getLocationRegionId())
        .setId(supplierParam.getId())
        .setSupplierCode(supplierParam.getSupplierCode())
        .setName(supplierParam.getName())
        .setEmail(supplierParam.getEmail())
        .setPhone(supplierParam.getPhone())
        .setStatus(supplierParam.getStatus())
        .setDescription(supplierParam.getDescription())
        .setEmployeeId(supplierParam.getEmployeeId())
        .setLocationRegionId(supplierParam.getLocationRegionId());
    }

    public Supplier toModel(SupplierCreateParam supplierCreateParam) {
        return new Supplier(supplierCreateParam.getEmployeeId(), supplierCreateParam.getLocationRegionId())
        .setSupplierCode(supplierCreateParam.getSupplierCode())
        .setName(supplierCreateParam.getName())
        .setEmail(supplierCreateParam.getEmail())
        .setPhone(supplierCreateParam.getPhone())
        .setStatus(supplierCreateParam.getStatus())
        .setDescription(supplierCreateParam.getDescription())
        .setEmployeeId(supplierCreateParam.getEmployeeId())
        .setLocationRegionId(supplierCreateParam.getLocationRegionId());
    }

    public Supplier toModel(SupplierUpdateParam supplierUpdateParam) {
        return new Supplier(supplierUpdateParam.getEmployeeId(), supplierUpdateParam.getLocationRegionId())
        .setSupplierCode(supplierUpdateParam.getSupplierCode())
        .setName(supplierUpdateParam.getName())
        .setEmail(supplierUpdateParam.getEmail())
        .setPhone(supplierUpdateParam.getPhone())
        .setStatus(supplierUpdateParam.getStatus())
        .setDescription(supplierUpdateParam.getDescription())
        .setEmployeeId(supplierUpdateParam.getEmployeeId())
        .setLocationRegionId(supplierUpdateParam.getLocationRegionId());
    }

}