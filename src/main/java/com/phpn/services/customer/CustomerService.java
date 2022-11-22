package com.phpn.services.customer;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.CustomerGender;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    void  deleteCustomer (Integer id);

    void  deleteStatusCustomer(Integer id);

    CustomerResult findById(Integer id);


    CustomerResult createCustomerResult(CustomerCreate customerCreate);


    Customer create(CustomerCreate customerCreate);

    List<CustomerResult> findCustomerByDeleted(boolean deleted);

    List<CustomerResult> findAllCustomerResultByDeleted(boolean deleted);

    List<CustomerResult> findAll();


    Customer update(CustomerResult customerResult);


     CustomerGender[] findAllByCustomerGender();

    List<CustomerResult> findAllCustomerByDelete(boolean deleted);
}
