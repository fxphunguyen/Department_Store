package com.phpn.services.customer;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.repositories.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerResult> findAllCustomer();

    void  deleteCustomer (Long id);
    ResponseEntity<?> createCustomer(Customer customer);
    List<CustomerResult> findById(Integer id);
    CustomerResult createCustomerResult( CustomerCreate customerCreate);

    CustomerResult create(CustomerCreate customerCreate);
    List<CustomerResult> findCustomerByDeleted(boolean deleted);

    List<CustomerResult> findAllCustomerResultByDeleted(boolean deleted);


}
