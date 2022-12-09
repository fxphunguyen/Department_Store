package com.phpn.customer.service;

import com.phpn.customer.dto.CustomerResult;
import com.phpn.customer.UpdateCustomerParam;
import com.phpn.customer.dto.CreateCustomerParam;
import com.phpn.order.sale.dto.SaleOrderByCustomer;
import com.phpn.order.sale.dto.SaleOrderResult;

import java.util.List;

public interface CustomerService {

    CustomerResult findById(Integer id);

    List<CustomerResult> findAll();

    CustomerResult create(CreateCustomerParam customerCreate);

    CustomerResult update(UpdateCustomerParam updateCustomer);

    List<SaleOrderResult> findHistoryCustomerOrder(Integer id);


}
