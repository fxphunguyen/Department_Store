package com.phpn.order;

import com.phpn.dto.purchase_order.PurchaseOrderResult;
import com.phpn.payment.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/purchases")
public class PurchaseOrderAPI {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @GetMapping("")
    public ResponseEntity<?> showListPurchase() {
        List<PurchaseOrderResult> purchaseOrderResults = purchaseOrderService.findAll();
        return new ResponseEntity<>(purchaseOrderResults, HttpStatus.OK);
    }


}
