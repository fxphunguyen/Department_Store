package com.phpn.mappers.customer;


import com.phpn.dto.customer.CreateCustomerParam;
import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.CustomerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    @Autowired
    private EmployeeMapper employeeMapper;


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
                .setCustomerStatus(customer.getCustomerStatus());
//                .setLocationRegionId(customer.getLocationRegionId())
//                .setLocationRegionResult(locationRegionMapper.toDTO(customer.getLocationRegion()));

    }
    public CustomerOrderResult toOrderDTO(Customer customer) {
        return new CustomerOrderResult()
                .setId(customer.getId())
                .setCustomerCode(customer.getCustomerCode())
                .setName(customer.getName())
                .setPhone(customer.getPhone())
                .setEmployeeId(customer.getEmployeeId())
                .setEmployee(employeeMapper.toDTO(customer.getEmployee()));
              //  .setDeleted(customer.getDeleted());
    }

    public Customer toModel(CreateCustomerParam customerCreate) {
        return new Customer()
                .setEmployeeId(customerCreate.getEmployeeId())
                .setCustomerCode(customerCreate.getCustomerCode())
                .setName(customerCreate.getName())
                .setPhone(customerCreate.getPhone())
                .setCustomerGroup(customerCreate.getCustomerGroup())
                .setEmail(customerCreate.getEmail())
                .setBirthday(customerCreate.getBirthday())
                .setCustomerStatus(CustomerStatus.AVAILABLE)
//                .setCreateAt(java.time.LocalDateTime.now().toString())
//                .setUpdateAt(customerCreate.getUpdateAt())
                .setCustomerGender(customerCreate.getCustomerGender());
//                .setLocationRegionId(customerCreate.getLocationRegionId());
    }

    public Customer toCustomer( CreateCustomerParam customerCreate) {
        return new Customer()
                .setId(customerCreate.getId())
                .setCustomerCode(customerCreate.getCustomerCode())
                .setName(customerCreate.getName())
                .setPhone(customerCreate.getPhone())
                .setCustomerGroup(customerCreate.getCustomerGroup())
                .setCustomerGender(customerCreate.getCustomerGender())
                .setEmail(customerCreate.getEmail())
                .setBirthday(customerCreate.getBirthday())
                .setCustomerStatus(customerCreate.getCustomerStatus());
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
                .setUpdateAt(customerResult.getUpdateAt());

    }



}