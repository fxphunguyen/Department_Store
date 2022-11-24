package com.phpn.controllers.api;


import com.phpn.repositories.OrderRepository;
import com.phpn.repositories.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderText {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<?> showAllListCustomer(){
        List<Order> order = orderRepository.findAll() ;
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
