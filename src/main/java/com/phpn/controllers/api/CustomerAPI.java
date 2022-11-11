package com.phpn.controllers.api;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.mappers.customer.CustomerMapper;


import com.phpn.mappers.localtionRegion.LocaltionRegionMapper;


import com.phpn.mappers.localtionRegion.LocaltionRegionMapper;
import com.phpn.repositories.CustomerRepository;
import com.phpn.repositories.model.Customer;

import com.phpn.repositories.model.LocationRegion;

import com.phpn.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerAPI {

    @Autowired
    private LocaltionRegionMapper LocaltionRegionMapper;

    @Autowired
    private CustomerService customerService;


    @Autowired
    CustomerRepository customerRepository;

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

      @GetMapping("/customer_list")
        public ResponseEntity<?> showListCustomerByDelete(boolean deleted) {
    List<CustomerResult> customers = customerService.findAllCustomerResultByDeleted(deleted);
    return new ResponseEntity<>(customers, HttpStatus.OK);
}

    @PostMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerCreate[] customerCreates) {
        CustomerCreate customerCreate = new CustomerCreate();
        Customer customer = new Customer();
        for (CustomerCreate iteam : customerCreates) {
            customerCreate.setId(iteam.getId());
            customerCreate.setCustomerCode(iteam.getCustomerCode());
            customerCreate.setName(iteam.getName());
            customerCreate.setPhone(iteam.getPhone());
            customerCreate.setCustomerGroup(iteam.getCustomerGroup());
            customerCreate.setEmail(iteam.getEmail());
            customerCreate.setBirthday(iteam.getBirthday());
            customerCreate.setStatus(iteam.getStatus());
            customerCreate.setCreateAt(String.valueOf(Instant.now()));
//
////            customer.getLocationRegion().setId()
//
//            customerService.create(customerCreate);
        }


        return new ResponseEntity<>(HttpStatus.OK);
    }

}
