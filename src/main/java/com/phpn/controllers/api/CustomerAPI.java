package com.phpn.controllers.api;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.dto.customer.CustomerResult;


import com.phpn.mappers.customer.CustomerMapper;
import com.phpn.mappers.localtionRegion.LocationRegionMapper;
import com.phpn.repositories.CustomerRepository;
import com.phpn.repositories.LocationRegionRepository;
import com.phpn.repositories.OrderRepository;
import com.phpn.repositories.model.*;
import com.phpn.services.customer.CustomerService;
import com.phpn.services.locationRegion.LocationRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerAPI {

    @Autowired
    private LocationRegionRepository locationRegionRepository;

    @Autowired
    private LocationRegionMapper locationRegionMapper;

    @Autowired
    private LocationRegionService locationRegionService;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/list_customerAll")
    @Transactional(readOnly = true)
    public ResponseEntity<?> showListCustomerAll() {
        List<CustomerResult> customers = customerRepository.findAll().stream().map(customer -> customerMapper.toDTO(customer)).collect(Collectors.toList());
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


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
        CustomerResult customerResult = customerService.findById(id);
        return new ResponseEntity<>(customerResult, HttpStatus.OK);
    }


    @PostMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable Integer id) {
        customerService.deleteStatusCustomer(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerCreate customerCreate) {
        Customer customer = customerService.create(customerCreate);
        return new ResponseEntity<>(customer, HttpStatus.OK);

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerResult customerResult) {

        CustomerResult customerResult1 = customerService.findById(customerResult.getId());

        if (customerResult1 == null) {
            System.out.println("Không tìm thấy địa chỉ ad phù hợp");
        }
        customerService.update(customerResult);

        customerResult.getLocationRegionResult().setId(customerResult1.getLocationRegionId());

        if ((customerResult.getLocationRegionResult()) == null) {
            System.out.println("Dữ liệu ở location bị null");
        }
        locationRegionService.update(customerResult.getLocationRegionResult());
        return new ResponseEntity<>(customerResult, HttpStatus.OK);
    }

    @PutMapping("/updateCustomerOrder/{id}")
    public ResponseEntity<?> updateCustomerOrder(@RequestBody CustomerOrderResult customerOrderResult, @PathVariable Integer id) {


        CustomerOrderResult customerOrderResult1 = customerService.findByIdCustomerOrder(customerOrderResult.getId());
        customerService.updateCustomerOrder(customerOrderResult);
        customerOrderResult.getLocationRegionResult().setId(customerOrderResult1.getLocationRegionId());
        locationRegionService.update(customerOrderResult.getLocationRegionResult());
        return new ResponseEntity<>(customerOrderResult, HttpStatus.OK);
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

    @GetMapping("/customerStatus")
    public CustomerStatus[] findAllByCustomerStatus() {
        CustomerStatus[] customerStatuses = CustomerStatus.values();
        return customerStatuses;
    }

//    @GetMapping("/showAllCustomerMixInfo")
//    public ResponseEntity<?> showAllCustomerMixInfo() {
//        List<ICustomer> iCustomers = customerRepository.getAllCustomerMixInfo();
//        List<ICustomerImpl> iCustomerImpls = iCustomers.stream().map(iCustomer -> {
//            ICustomerImpl iCustomerImpl = new ICustomerImpl();
//            iCustomerImpl.setFromICustomer(iCustomer);
//            return iCustomerImpl;
//        }).collect(Collectors.toList());
//        return new ResponseEntity<>(iCustomerImpls, HttpStatus.OK);
//    }
//
//

    @GetMapping("/showAllCustomerMixInfo")
    public ResponseEntity<?> showAllCustomerMixInfo() {
        List<ICustomer> iCustomers = customerService.showAllCustomerMixInfo();
        return new ResponseEntity<>(iCustomers, HttpStatus.OK);
    }
    @GetMapping("/showAllCustomerMixInfoByStatus")
    public ResponseEntity<?> showAllCustomerMixInfoByStatus() {
        List<ICustomer> iCustomers = customerService.showAllCustomerMixInfoByStatus();
        return new ResponseEntity<>(iCustomers, HttpStatus.OK);
    }
    @GetMapping("/customerInfo/{id}")
    public  ResponseEntity<?> showListCustomerInfo(@PathVariable Integer id){
        ICustomer iCustomer = customerService.CustomerInfoById(id);
        return  new ResponseEntity<>(iCustomer, HttpStatus.OK);
    }

    @GetMapping("/historyCustomerOrder/{id}")
    @Transactional(readOnly = true)
    public  ResponseEntity<?> showListCustomerOrderById(@PathVariable Integer id){
        List<Order> order = orderRepository.findAllOrderByCustomerId(id);
        return  new ResponseEntity<>(order, HttpStatus.OK);
    }
}
