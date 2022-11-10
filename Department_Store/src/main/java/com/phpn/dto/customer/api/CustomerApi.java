package com.phpn.dto.customer.api;
import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.repositories.CustomerRepository;
import com.phpn.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/customer")
public class CustomerApi {

@Autowired
CustomerRepository customerRepository;


@Autowired
CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<?> showAllCustomer(){
        List<CustomerResult> customerResultList = customerRepository.findAllCustomer();
        return  new ResponseEntity<>(customerResultList, HttpStatus.OK);
    }
//    @PostMapping("/delete/{id}")
//    public void deleteCustomerById(@PathVariable Integer id){
//        customerService.deleteCustomer(id);
//    }
//    @PostMapping("/create")
//    public ResponseEntity<?> createCustomer(@RequestBody CustomerCreate[] customerCreates){
//
//            CustomerCreate customerCreate = new CustomerCreate();
//
//            customerRepository.save(customerCreates);
//
//
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }



}
