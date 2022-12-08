package com.phpn.payment;

import java.util.List;

import com.phpn.order.PaymentMethodResult;
import com.phpn.payment.PaymentMethodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/payment_methods")
public class PaymentMethodAPI {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public ResponseEntity<List<PaymentMethodResult>> findAll() {
        return new ResponseEntity<>(paymentMethodService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}/histories")
    public ResponseEntity<PaymentMethodResult> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(paymentMethodService.findById(id), HttpStatus.OK);
    }

}