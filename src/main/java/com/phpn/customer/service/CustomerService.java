package com.phpn.customer.service;

import com.phpn.customer.CustomerResult;
import com.phpn.customer.UpdateCustomerParam;
import com.phpn.customer.dto.CreateCustomerParam;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {

    CustomerResult findById(Integer id);

    List<CustomerResult> findAll();

    CustomerResult create(CreateCustomerParam customerCreate);

    CustomerResult update(UpdateCustomerParam updateCustomer);



}
