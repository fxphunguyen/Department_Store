package com.phpn.controllers.api;

import com.phpn.dto.orderItem.OrderItemParam;
import com.phpn.services.order_item.OrderItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderItems")
public class OrderItemAPI {

    @Autowired
    private OrderItemServiceImpl orderItemService;


    @PostMapping("/create")
    public ResponseEntity<?> createOrderItem(@RequestBody OrderItemParam orderItemParam) {
        return new ResponseEntity<>(orderItemService.createOrderItem(orderItemParam), HttpStatus.OK);
    }

}
