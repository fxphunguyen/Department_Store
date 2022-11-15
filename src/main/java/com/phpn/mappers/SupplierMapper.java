//package com.phpn.mappers;
//
//import com.phpn.dto.supplier.SupplierCreateParam;
//import com.phpn.dto.supplier.SupplierParam;
//import com.phpn.dto.supplier.SupplierResult;
//import com.phpn.mappers.employee.EmployeeMapper;
//import com.phpn.mappers.localtionRegion.LocaltionRegionMapper;
//import com.phpn.repositories.model.Supplier;
//import org.springframework.stereotype.Component;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@Component
//public class SupplierMapper {
//
//    @Autowired
//    private EmployeeMapper employeeMapper;
//
//    @Autowired
//    private LocaltionRegionMapper localtionRegionMapper;
//
//    public Supplier toModel(SupplierCreateParam supplierCreateParam) {
//        return new Supplier(supplierCreateParam.getEmployeeId(), supplierCreateParam.setLocationRegionId())
//                .setSupplierCode(supplierCreateParam.getSupplierCode())
//                .setName(supplierCreateParam.getName())
//                .setEmail(supplierCreateParam.getEmail())
//                .setPhone(supplierCreateParam.getPhone())
//                .setStatus(supplierCreateParam.getStatus())
//                .setDescription(supplierCreateParam.getDescription())
//                .setEmployeeId(supplierCreateParam.getEmployeeId())
//                .setLocationRegionId(supplierCreateParam.getLocationRegionId());
//    }
//
//    public Supplier toModel(SupplierParam supplierParam) {
//        return new Supplier(supplierParam.getEmployeeId(), supplierParam.getLocationRegionId())
//        .setId(supplierParam.getId())
//        .setSupplierCode(supplierParam.getSupplierCode())
//        .setName(supplierParam.getName())
//        .setEmail(supplierParam.getEmail())
//        .setPhone(supplierParam.getPhone())
//        .setStatus(supplierParam.getStatus())
//        .setDescription(supplierParam.getDescription())
//        .setEmployeeId(supplierParam.getEmployeeId())
//        .setLocationRegionId(supplierParam.getLocationRegionId());
//    }
//
//    public SupplierResult toDTO(Supplier supplier) {
//        return new SupplierResult()
//        .setId(supplier.getId())
//        .setSupplierCode(supplier.getSupplierCode())
//        .setName(supplier.getName())
//        .setEmail(supplier.getEmail())
//        .setPhone(supplier.getPhone())
//        .setStatus(supplier.getStatus())
//        .setDescription(supplier.getDescription())
//        .setEmployeeId(supplier.getEmployeeId())
//        .setLocationRegionId(supplier.getLocationRegionId());
//    }
//
//}