package com.phpn.customer;

import com.phpn.customer.CustomerResult;
import vn.fx.qh.sapo.entities.customer.*;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {

    CustomerResult findById(Integer id);

    List<CustomerResult> findAll();

    CustomerResult create(CreateCustomerParam customerCreate);

    CustomerResult update(UpdateCustomerParam updateCustomer);



}
