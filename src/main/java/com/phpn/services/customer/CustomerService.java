package com.phpn.services.customer;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.repositories.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
<<<<<<< HEAD
=======
    void  deleteCustomer (Long id);
    ResponseEntity<?> createCustomer(Customer customer);
    List<CustomerResult> findById(Integer id);
    CustomerResult createCustomerResult( CustomerCreate customerCreate);

    CustomerResult create(CustomerCreate customerCreate);
    List<CustomerResult> findCustomerByDeleted(boolean deleted);

    List<CustomerResult> findAllCustomerResultByDeleted(boolean deleted);

>>>>>>> 9120c2af7e0c652f7a1143329c5de45d202f1f34

}
