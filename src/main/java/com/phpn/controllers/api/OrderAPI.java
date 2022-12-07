package com.phpn.controllers.api;

import com.phpn.dto.order.OrderParam;
import com.phpn.dto.order.OrderResult;
import com.phpn.services.customer.CustomerService;
import com.phpn.services.employee.EmployeeService;
import com.phpn.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderAPI {

    @Autowired
    private OrderService orderService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        List<OrderResult> orderResults = orderService.findAll();

        return new ResponseEntity<>(orderResults, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderParam orderParam) {

        return new ResponseEntity<>(orderService.createOrderExport(orderParam), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getAllOrderItemByOrderId(@PathVariable Integer orderId) {
        OrderResult orderResult = orderService.findById(orderId);
        return new ResponseEntity<>(orderResult,HttpStatus.OK);
    }

}
