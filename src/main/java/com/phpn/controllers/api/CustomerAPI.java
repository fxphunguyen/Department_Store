package com.phpn.controllers.api;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;


import com.phpn.mappers.localtionRegion.LocationRegionMapper;
import com.phpn.repositories.CustomerRepository;
import com.phpn.repositories.LocationRegionRepository;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.CustomerGender;
import com.phpn.repositories.model.CustomerGroup;
import com.phpn.services.customer.CustomerService;
import com.phpn.services.locationRegion.LocationRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/customers")
public class CustomerAPI {

    @Autowired
    private LocationRegionMapper locationRegionMapper;


    @Autowired
    private LocationRegionService locationRegionService;

    @Autowired
    private LocationRegionRepository locationRegionRepository;

    @Autowired
    private CustomerService customerService;


    @Autowired
    CustomerRepository customerRepository;


    @GetMapping("/list_customer")
    public ResponseEntity<?> showListCustomer(boolean deleted) {
        List<CustomerResult> customers = customerService.findAllCustomerResultByDeleted(deleted);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @GetMapping("/customer_list")
    public ResponseEntity<?> showListCustomerByDelete(boolean deleted) {
        List<CustomerResult> customers = customerService.findAllCustomerByDelete(deleted);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        CustomerResult itemResult = customerService.findById(id);
        return new ResponseEntity<>(itemResult, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable Integer id) {
        customerService.deleteStatusCustomer(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerCreate customerCreate) {
        System.out.println(customerCreate.getStatus());
        System.out.println(customerCreate.getCustomerGender());
        Customer customer = customerService.create(customerCreate);
        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerResult customerResult, @PathVariable Integer id) {
        customerResult.setId(id);
        customerService.update(customerResult);
        return new ResponseEntity<>(customerResult, HttpStatus.OK);

    }

    @GetMapping("/customerGroup")
    public CustomerGroup[] findAllByCustomerGroup() {
        CustomerGroup[] customerGroups = CustomerGroup.values();

        System.out.println(customerGroups);
        return customerGroups;
    }

    @GetMapping("/customerGender")
    public CustomerGender[] findAllByCustomerGender() {
        CustomerGender[] customerGender = CustomerGender.values();
        return customerGender;
    }

}
