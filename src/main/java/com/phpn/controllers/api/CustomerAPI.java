package com.phpn.controllers.api;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.mappers.customer.CustomerMapper;

import com.phpn.mappers.localtionRegion.LocaltionRegionMapper;

import com.phpn.repositories.CustomerRepository;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.LocationRegion;
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
    private LocaltionRegionMapper localtionRegionMapper;


    @Autowired
    private LocationRegionService locationRegionService;

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
        List<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdItem(@PathVariable Integer id) {
        CustomerResult itemResult = customerService.findById(id);
        return new ResponseEntity<>(itemResult, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerCreate customerCreate) {
        customerCreate.getLocationReionCreate().setId(0);
        LocationRegion locationRegion = locationRegionService.save(localtionRegionMapper.toModel(customerCreate));
        customerCreate.setLocationReionCreate(localtionRegionMapper.toModel(locationRegion));
        Customer customer = customerRepository.save(customerMapper.toModel(customerCreate));
        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerResult customerResult, @PathVariable Integer id) {
        customerResult.setId(id);
        customerService.update(customerResult);
        return new ResponseEntity<>(customerResult, HttpStatus.OK);

    }


}
