//package com.phpn.controllers.api;
//
//import com.phpn.dto.paymentOrder.PaymentOrderParam;
//import com.phpn.services.paymentOrder.PaymentOrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/paymentOrder")
//public class PaymentOrderAPI {
//
//    @Autowired
//    private PaymentOrderService paymentOrderService;
//
////    @GetMapping()
////    public ResponseEntity<?> findAll() {
////        List<PaymentOrderResult> paymentOrderResults = paymentOrderService.findAll();
////
////        return new ResponseEntity<>(paymentOrderResults, HttpStatus.OK);
////    }
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createPaymentOrder(@RequestBody PaymentOrderParam paymentOrderParam) {
//
//        return new ResponseEntity<>(paymentOrderService.createPaymentOrder(paymentOrderParam), HttpStatus.OK);
//    }
//
//}