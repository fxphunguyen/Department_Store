package com.phpn.controllers.api;

import com.phpn.dto.paymentOrder.PaymentOrderParam;
import com.phpn.services.paymentOrder.PaymentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paymentOrder")
public class PaymentOrderAPI {

    @Autowired
    private PaymentOrderService paymentOrderService;

    @PostMapping("/create")
    public ResponseEntity<?> createPaymentOrder(@RequestBody PaymentOrderParam paymentOrderParam) {

        return new ResponseEntity<>(paymentOrderService.createPaymentOrder(paymentOrderParam), HttpStatus.OK);
    }

}