package com.phpn.mappers.customer;


import com.phpn.dto.customer.CreateCustomerParam;
import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.dto.shipping_address.ShippingAddressResult;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.CustomerStatus;
import com.phpn.repositories.model.ShippingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CustomerMapper {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private ShippingAddressMapper shippingAddressMapper;


    public CustomerResult toDTO(Customer customer) {
        CustomerResult result = new CustomerResult()
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
        Set<ShippingAddress> shippingAddressSet = customer.getShippingAddressSet();
        List<ShippingAddressResult> shippingAddressList = shippingAddressSet.stream()
                .map(shippingAddressMapper::toDTO).collect(Collectors.toList());
        result.setShippingAddressList(shippingAddressList);
        Optional<ShippingAddressResult> shippingAddressOpt = shippingAddressList.stream().filter(ShippingAddressResult::isDefault).findFirst();
        shippingAddressOpt.ifPresent(result::setShippingAddressDefault);
        return result;
//                .setShippingAddressList(new ArrayList<ShippingAddressResult>(customer.getShippingAddressSet()));

    }

    public CustomerOrderResult toOrderDTO(Customer customer) {
        return new CustomerOrderResult()
                .setId(customer.getId())
                .setCustomerCode(customer.getCustomerCode())
                .setName(customer.getName())
                .setPhone(customer.getPhone())
                .setShippingAddressSet(customer.getShippingAddressSet())
                .setEmployeeId(customer.getEmployeeId());
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
                .setCustomerStatus(CustomerStatus.AVAILABLE);
    }

    public Customer toCustomer(CreateCustomerParam customerCreate) {
        return new Customer()
                .setId(customerCreate.getId())
                .setCustomerCode(customerCreate.getCustomerCode())
                .setName(customerCreate.getName())
                .setPhone(customerCreate.getPhone())
                .setCustomerGroup(customerCreate.getCustomerGroup())
                .setCustomerGender(customerCreate.getCustomerGender())
                .setEmail(customerCreate.getEmail())
                .setBirthday(customerCreate.getBirthday())
                .setCustomerGender(customerCreate.getCustomerGender())
                .setCustomerStatus(customerCreate.getCustomerStatus())
                .setEmployeeId(customerCreate.getEmployeeId());
    }

    public Customer toCustomer(CustomerResult customerResult, Customer customer) {
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