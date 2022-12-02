package com.phpn.mappers.customer;


import com.phpn.dto.customer.CreateCustomerParam;
import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.dto.customer.CustomerParam;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.mappers.employee.EmployeeMapper;
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
<<<<<<< HEAD
=======
//                .setLocationRegionId(customer.getLocationRegionId())
//                .setLocationRegionResult(locationRegionMapper.toDTO(customer.getLocationRegion()));

>>>>>>> phu_dev
    }
    public CustomerOrderResult toOrderDTO(Customer customer) {
        return new CustomerOrderResult()
                .setId(customer.getId())
                .setCustomerCode(customer.getCustomerCode())
                .setName(customer.getName())
                .setPhone(customer.getPhone())
                .setEmployeeId(customer.getEmployeeId())
<<<<<<< HEAD
                .setEmployee(employeeMapper.toOrderDTO(customer.getEmployee()))
                .setDeleted(customer.getDeleted());
=======
                .setEmployee(employeeMapper.toDTO(customer.getEmployee()));
              //  .setDeleted(customer.getDeleted());
>>>>>>> phu_dev
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
<<<<<<< HEAD
                .setCreateAt(java.time.LocalDateTime.now().toString())
                .setUpdateAt(customerCreate.getUpdateAt())
                .setCustomerGender(customerCreate.getCustomerGender());
=======
//                .setCreateAt(java.time.LocalDateTime.now().toString())
//                .setUpdateAt(customerCreate.getUpdateAt())
                .setCustomerGender(customerCreate.getCustomerGender());
//                .setLocationRegionId(customerCreate.getLocationRegionId());
>>>>>>> phu_dev
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
<<<<<<< HEAD
                .setCustomerStatus(customerCreate.getCustomerStatus())
                .setCreateAt(customerCreate.getCreateAt())
                .setUpdateAt(customerCreate.getUpdateAt());
=======
                .setCustomerStatus(customerCreate.getCustomerStatus());
>>>>>>> phu_dev
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

<<<<<<< HEAD

    public CustomerOrderResult toDTOCustomerOrder(Customer customer) {
        return new CustomerOrderResult()
                .setId(customer.getId())
                .setCustomerCode(customer.getCustomerCode())
                .setName(customer.getName())
                .setPhone(customer.getPhone())
                .setEmployeeId(customer.getEmployeeId());
=======
    public Customer toModel(CustomerParam customerParam) {
        return new Customer()
                .setId(customerParam.getId())
                .setEmployeeId(customerParam.getEmployeeId())
                .setCustomerCode(customerParam.getCustomerCode())
                .setName(customerParam.getName())
                .setPhone(customerParam.getPhone())
                .setCreateAt(java.time.LocalDateTime.now().toString())
                .setLocationRegionId(customerParam.getLocationRegionId());
>>>>>>> 3b66ad51328ce8e461613c0e16cc121d6712cdb6
    }



}