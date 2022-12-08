package com.phpn.payment.purchase;

import com.phpn.payment.sale.PaymentOrderParam;
import com.phpn.payment.sale.PaymentSaleOrderResult;
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
    private PaymentSaleOrderService paymentOrderService;


    @Autowired
    private PaymentOrderRepository paymentOrderRepository;

    @Autowired
    private PaymentSaleOrderMapper paymentOrderMapper;

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
                .map(paymentOrder -> paymentOrderMapper.toDTO(paymentOrder))
                .collect(Collectors.toList());
        return new ResponseEntity<>(paymentOrderResult, HttpStatus.OK);
    }


}

