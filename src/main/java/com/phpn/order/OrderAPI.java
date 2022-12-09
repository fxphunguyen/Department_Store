package com.phpn.order;

import com.phpn.order.sale.dto.SaleOrderParam;
import com.phpn.order.sale.dto.SaleOrderResult;
import com.phpn.customer.service.CustomerService;
import com.phpn.employee.EmployeeService;
import com.phpn.order.sale.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderAPI {

    @Autowired
    private SaleOrderService orderService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        List<SaleOrderResult> orderResults = orderService.findAll();

        return new ResponseEntity<>(orderResults, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody SaleOrderParam orderParam) {
        return new ResponseEntity<>(orderService.create(orderParam), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findById(@PathVariable Integer orderId) {
        SaleOrderResult orderResult = orderService.findById(orderId);
        return new ResponseEntity<>(orderResult,HttpStatus.OK);
    }

}
