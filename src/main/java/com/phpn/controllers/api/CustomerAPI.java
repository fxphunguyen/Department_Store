package com.phpn.controllers.api;

import com.phpn.dto.customer.CustomerResult;
import com.phpn.mappers.customer.CustomerMapper;
import com.phpn.repositories.model.Customer;
import com.phpn.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerAPI {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping("/list_customer")
    public ResponseEntity<?> showListCustomer(boolean deleted) {
        List<CustomerResult> customers = customerService.findAllCustomerResultByDeleted(deleted);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/show_customer")
    public ResponseEntity<?> findNameAndPhoneDeletedFalse(boolean deleted) {
        List<CustomerResult> customerResults = customerService.findCustomerByDeleted(deleted);
        return new ResponseEntity<>(customerResults, HttpStatus.OK);
    }

}
