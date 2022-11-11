package com.phpn.dto.customer.api;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.repositories.CustomerRepository;
import com.phpn.repositories.model.Customer;
import com.phpn.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/admin/customer")
public class CustomerApi {

    @Autowired
    CustomerRepository customerRepository;


    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<?> showAllCustomer() {
        List<CustomerResult> customerResultList = customerRepository.findAllCustomer();
        return new ResponseEntity<>(customerResultList, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable Long id) {
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
