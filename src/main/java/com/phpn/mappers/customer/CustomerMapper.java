package com.phpn.mappers.customer;


import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.mappers.localtionRegion.LocationRegionMapper;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.CustomerStatus;
import com.phpn.repositories.model.ICustomerOwer;
import com.phpn.repositories.model.ICustomerOwerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
                .setCustomerStatus(customer.getCustomerStatus())
                .setCreateAt(customer.getCreateAt())
                .setUpdateAt(customer.getUpdateAt())
                .setEmployeeId(customer.getEmployeeId())
                .setCustomerStatus(customer.getCustomerStatus())
                .setLocationRegionId(customer.getLocationRegionId())
                .setLocationRegionResult(locationRegionMapper.toDTO(customer.getLocationRegion()));

    }
    public Customer toOrderDTO(CustomerOrderResult customerOrderResult , Customer customer) {
        return  customer
                .setId(customer.getId())
                .setCustomerCode(customerOrderResult.getCustomerCode())
                .setName(customerOrderResult.getName())
                .setPhone(customerOrderResult.getPhone())
                .setUpdateAt(java.time.LocalDateTime.now().toString())
                .setEmployeeId(customerOrderResult.getEmployeeId());
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
                .setCustomerStatus(CustomerStatus.AVAILABLE)
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
                .setCustomerStatus(customerCreate.getCustomerStatus())
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
                .setCustomerStatus(customerResult.getCustomerStatus())
                .setUpdateAt(customerResult.getUpdateAt())
                .setUpdateAt(java.time.LocalDateTime.now().toString())
                .setDeleted(true);

    }


    public CustomerOrderResult toDTOCustomerOrder(Customer customer) {
        return new CustomerOrderResult()
                .setId(customer.getId())
                .setCustomerCode(customer.getCustomerCode())
                .setName(customer.getName())
                .setPhone(customer.getPhone())
                .setEmployeeId(customer.getEmployeeId())
                .setLocationRegionResult(locationRegionMapper.toDTO(customer.getLocationRegion()));
    }



}