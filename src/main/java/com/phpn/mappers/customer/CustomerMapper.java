package com.phpn.mappers.customer;


import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;

import com.phpn.mappers.localtionRegion.LocationRegionMapper;
import com.phpn.repositories.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.phpn.repositories.model.CustomerGroup.VIP;


@Component
public class CustomerMapper {


    @Autowired
    LocationRegionMapper locationRegionMapper;

    public CustomerResult toDTO(Customer customer) {
        return new CustomerResult()
                .setId(customer.getId())
                .setCustomerCode(customer.getCustomerCode())
                .setName(customer.getName())
                .setPhone(customer.getPhone())
                .setCustomerGroup(customer.getCustomerGroup())
                .setEmail(customer.getEmail())
                .setBirthday(customer.getBirthday())
                .setStatus(customer.getStatus())
                .setCreateAt(customer.getCreateAt())
                .setUpdateAt(customer.getUpdateAt())
                .setEmployeeId(customer.getEmployeeId())
                .setLocationRegionId(customer.getLocationRegionId());

    }

    public Customer toModel(CustomerCreate customerCreate) {
        return new Customer()
                .setEmployeeId(2)
                .setCustomerCode(customerCreate.getCustomerCode())
                .setName(customerCreate.getName())
                .setPhone(customerCreate.getPhone())
                .setCustomerGroup(customerCreate.getCustomerGroup())
                .setEmail(customerCreate.getEmail())
                .setBirthday(customerCreate.getBirthday())
                .setStatus(customerCreate.getStatus())
                .setCreateAt(customerCreate.getCreateAt())
                .setUpdateAt(customerCreate.getUpdateAt())
                .setLocationRegion(locationRegionMapper.toModel(customerCreate));

    }


    public Customer toModel(CustomerResult customerResult) {
        return new Customer(customerResult.getLocationRegionId(), customerResult.getLocationRegionId())
                .setId(customerResult.getId())
                .setCustomerCode(customerResult.getCustomerCode())
                .setName(customerResult.getName())
                .setPhone(customerResult.getPhone())
                .setCustomerGroup(customerResult.getCustomerGroup())
                .setEmail(customerResult.getEmail())
                .setBirthday(customerResult.getBirthday())
                .setStatus(customerResult.getStatus())
                .setCreateAt(customerResult.getCreateAt())
                .setUpdateAt(customerResult.getUpdateAt())
                .setDeleted(customerResult.getDeleted());
    }

}