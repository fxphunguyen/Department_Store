package com.phpn.controllers.api;

import com.phpn.order.sale.dto.OrderItemResult;
import com.phpn.order.sale.OrderItemServiceImpl;
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
