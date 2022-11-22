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

@Component
public class CustomerMapper {


    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private LocationRegionMapper locationRegionMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LocationRegionRepository locationRegionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

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
//                .setLocationRegion(locationRegionRepository.findById(customer.getLocationRegionId()).get())
                .setEmployeeRResult(employeeMapper.toRDTO(customer.getEmployee()));
    }

    public Customer toModel(CustomerCreate customerCreate) {
        return new Customer(customerCreate.getEmployeeId(), customerCreate.getLocationRegionID())
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
                .setLocationRegionId(customerCreate.getLocationRegionID());
    }

    public Customer toCustomer(CustomerResult customerResult) {
        Customer customer = customerRepository.findById(customerResult.getId()).get();
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


    public Customer toModel(CustomerResult customerResult) {
        return new Customer(customerResult.getLocationRegionId(), customerResult.getLocationRegionId())
                .setId(customerResult.getId())
                .setCustomerCode(customerResult.getCustomerCode())
                .setName(customerResult.getName())
                .setPhone(customerResult.getPhone())
                .setCustomerGroup(customerResult.getCustomerGroup())
                .setCustomerGender(customerResult.getCustomerGender())
                .setEmail(customerResult.getEmail())
                .setBirthday(customerResult.getBirthday())
                .setStatus(customerResult.getStatus())
                .setCreateAt(customerResult.getCreateAt())
                .setUpdateAt(customerResult.getUpdateAt())
                .setEmployeeId(customerResult.getEmployeeId())
                .setLocationRegionId(customerResult.getLocationRegionId())
                .setLocationRegion(locationRegionMapper.toModel(customerResult));
    }

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