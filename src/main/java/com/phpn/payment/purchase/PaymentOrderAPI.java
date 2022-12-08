package com.phpn.payment;

import com.phpn.order.sale.dto.PaymentOrderParam;
import com.phpn.order.sale.dto.PaymentSaleOrderResult;
import com.phpn.payment.PaymentOrderMapper;
import com.phpn.payment.PaymentOrderRepository;
import com.phpn.payment.PaymentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/paymentOrder")
public class PaymentOrderAPI {

    @Autowired
    private PaymentOrderService paymentOrderService;


    @Autowired
    private PaymentOrderRepository paymentOrderRepository;

    @Autowired
    private PaymentOrderMapper paymentOrderMapper;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<PaymentSaleOrderResult> paymentOrderResults = paymentOrderService.findAll();

        return new ResponseEntity<>(paymentOrderResults, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPaymentOrder(@RequestBody PaymentOrderParam paymentOrderParam) {

        return new ResponseEntity<>(paymentOrderService.createPaymentOrder(paymentOrderParam), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        List<PaymentSaleOrderResult> paymentOrderResult = paymentOrderRepository.findAllByOrderId(id).stream()
                .map(paymentOrder -> paymentOrderMapper.toOrderInfo(paymentOrder))
                .collect(Collectors.toList());
        return new ResponseEntity<>(paymentOrderResult, HttpStatus.OK);
    }


}

