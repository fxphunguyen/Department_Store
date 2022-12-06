package com.phpn.controllers.api;

import com.phpn.dto.orderItem.OrderItemParam;
import com.phpn.dto.orderItem.OrderItemResult;
import com.phpn.services.order_item.OrderItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderItems")
public class OrderItemAPI {

    @Autowired
    private OrderItemServiceImpl orderItemService;

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getAllOrderItemByOrderId(@PathVariable Integer orderId) {
        List<OrderItemResult> orderItemResults = orderItemService.findAllOrderItemByOrderId(orderId);
        return new ResponseEntity<>(orderItemResults,HttpStatus.OK);
    }



}
