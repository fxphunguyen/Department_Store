package com.phpn.services.customer;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.mappers.customer.CustomerMapper;
import com.phpn.repositories.CustomerRepository;
import com.phpn.repositories.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;



public interface CustomerService {
    List<CustomerResult> findAllCustomer();

    void  deleteCustomer (Integer id);
    ResponseEntity<?> createCustomer(Customer customer);
    List<CustomerResult> findById(Integer id);
    CustomerResult createCustomerResult( CustomerCreate customerCreate);

}
