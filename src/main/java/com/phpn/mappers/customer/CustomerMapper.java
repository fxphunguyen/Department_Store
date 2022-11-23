package com.phpn.mappers.customer;


import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;

import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.mappers.localtionRegion.LocationRegionMapper;
import com.phpn.repositories.CustomerRepository;
import com.phpn.repositories.EmployeeRepository;
import com.phpn.repositories.LocationRegionRepository;
import com.phpn.repositories.model.Customer;
import javafx.scene.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerMapper {


    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private LocationRegionMapper locationRegionMapper;


    public CustomerResult toDTO(Customer customer) {
        return new CustomerResult()
                .setId(customer.getId())
                .setCustomerCode(customer.getCustomerCode())
                .setName(customer.getName())
                .setPhone(customer.getPhone())
                .setCustomerGroup(customer.getCustomerGroup())
                .setCustomerGender(customer.getCustomerGender())
                .setEmail(customer.getEmail())
                .setBirthday(customer.getBirthday())
                .setStatus(customer.getStatus())
                .setCreateAt(customer.getCreateAt())
                .setUpdateAt(customer.getUpdateAt())
                .setEmployeeId(customer.getEmployeeId())
                .setLocationRegionId(customer.getLocationRegionId())
                .setLocationRegionResult(locationRegionMapper.toDTO(customer.getLocationRegion()))
                .setEmployeeResult(employeeMapper.toDTO(customer.getEmployee()));

    }

    public Customer toModel(CustomerCreate customerCreate) {
        return new Customer()
                .setEmployeeId(customerCreate.getEmployeeId())
                .setCustomerCode(customerCreate.getCustomerCode())
                .setName(customerCreate.getName())
                .setPhone(customerCreate.getPhone())
                .setCustomerGroup(customerCreate.getCustomerGroup())
                .setEmail(customerCreate.getEmail())
                .setBirthday(customerCreate.getBirthday())
                .setStatus(customerCreate.getStatus())
                .setCreateAt(java.time.LocalDateTime.now().toString())
                .setUpdateAt(customerCreate.getUpdateAt())
                .setCustomerGender(customerCreate.getCustomerGender())
                .setLocationRegionId(customerCreate.getLocationRegionId());
    }

    public Customer toCustomer( CustomerCreate customerCreate) {
        return new Customer()
                .setId(customerCreate.getId())
                .setCustomerCode(customerCreate.getCustomerCode())
                .setName(customerCreate.getName())
                .setPhone(customerCreate.getPhone())
                .setCustomerGroup(customerCreate.getCustomerGroup())
                .setCustomerGender(customerCreate.getCustomerGender())
                .setEmail(customerCreate.getEmail())
                .setBirthday(customerCreate.getBirthday())
                .setStatus(customerCreate.getStatus())
                .setCreateAt(customerCreate.getCreateAt())
                .setUpdateAt(customerCreate.getUpdateAt())
                .setLocationRegionId(customerCreate.getLocationRegionId())
                .setLocationRegion(locationRegionMapper.toModel(customerCreate.getLocationRegionCreate()));
    }

    public Customer toCustomer(CustomerResult customerResult ,Customer customer) {
        return customer
                .setId(customerResult.getId())
                .setCustomerCode(customerResult.getCustomerCode())
                .setName(customerResult.getName())
                .setPhone(customerResult.getPhone())
                .setCustomerGroup(customerResult.getCustomerGroup())
                .setCustomerGender(customerResult.getCustomerGender())
                .setEmail(customerResult.getEmail())
                .setBirthday(customerResult.getBirthday())
                .setStatus(customerResult.getStatus())
                .setUpdateAt(customerResult.getUpdateAt())
                .setUpdateAt(java.time.LocalDateTime.now().toString())
                .setDeleted(true);

    }




//    public Customer toModel(CustomerResult customerResult) {
//        return new Customer()
//                .setId(customerResult.getId())
//                .setCustomerCode(customerResult.getCustomerCode())
//                .setName(customerResult.getName())
//                .setPhone(customerResult.getPhone())
//                .setCustomerGroup(customerResult.getCustomerGroup())
//                .setCustomerGender(customerResult.getCustomerGender())
//                .setEmail(customerResult.getEmail())
//                .setBirthday(customerResult.getBirthday())
//                .setStatus(customerResult.getStatus())
//                .setCreateAt(customerResult.getCreateAt())
//                .setUpdateAt(customerResult.getUpdateAt())
//                .setEmployeeId(customerResult.getEmployeeId())
//                .setLocationRegionId(customerResult.getLocationRegionId())
//                .setLocationRegion(locationRegionMapper.toModel(customerResult.getLocationRegionResult().));
//    }


    public CustomerResult toDTOCustomerEdit(Customer customer) {
        return new CustomerResult()
                .setId(customer.getId())
                .setCustomerCode(customer.getCustomerCode())
                .setName(customer.getName())
                .setPhone(customer.getPhone())
                .setCustomerGroup(customer.getCustomerGroup())
                .setCustomerGender(customer.getCustomerGender())
                .setEmail(customer.getEmail())
                .setBirthday(customer.getBirthday())
                .setStatus(customer.getStatus())
                .setCreateAt(customer.getCreateAt())
                .setUpdateAt(customer.getUpdateAt())
                .setEmployeeId(customer.getEmployeeId())
                .setDeleted(customer.getDeleted());
    }


}