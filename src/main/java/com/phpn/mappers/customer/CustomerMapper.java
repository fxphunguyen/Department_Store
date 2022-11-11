package com.phpn.mappers.customer;


import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.repositories.model.Customer;
import org.springframework.stereotype.Component;


@Component
public class CustomerMapper {

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
                .setAddress(customer.getUpdateAt());
    }
    public Customer toModel(CustomerCreate customerCreate) {
//        return new Customer(customerCreate.getId(),customerCreate.)
        return new Customer()
                .setId(customerCreate.getId())
                .setCustomerCode(customerCreate.getCustomerCode())
                .setName(customerCreate.getName())
                .setPhone(customerCreate.getPhone())
                .setCustomerGroup(customerCreate.getCustomerGroup())
                .setEmail(customerCreate.getEmail())
                .setBirthday(customerCreate.getBirthday())
                .setStatus(customerCreate.getStatus())
                .setCreateAt(customerCreate.getCreateAt())
                .setUpdateAt(customerCreate.getUpdateAt());
    }
}