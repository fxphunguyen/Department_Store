package com.phpn.controllers.api;

import com.phpn.dto.order.OrderParam;
import com.phpn.services.customer.CustomerService;
import com.phpn.services.employee.EmployeeService;
import com.phpn.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderAPI {

    @Autowired
    private OrderService orderService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    public void mamam() {
        
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderParam orderParam) {
        return new ResponseEntity<>(orderService.createOrderExport(orderParam), HttpStatus.OK);
    }

}
