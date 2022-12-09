package com.phpn.tax;

import com.phpn.brand.dto.BrandParam;
import com.phpn.tax.dto.TaxParam;
import com.phpn.tax.dto.TaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vn.fx.qh.sapo.entities.product.Brand;
import vn.fx.qh.sapo.entities.product.tax.Tax;

import java.util.List;

@RestController
@RequestMapping("/api/taxes")
public class TaxAPI {
    @Autowired
    TaxService taxService;

    @GetMapping("")
    public ResponseEntity<?> showAllTax(){
        List<TaxResult> taxes =  taxService.findAllTax();
        System.out.println(taxes);
        return new ResponseEntity<>(taxes, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTax(@RequestBody TaxParam taxParam){
        TaxResult taxResult = taxService.create(taxParam);
        return new ResponseEntity<>(taxResult, HttpStatus.OK);
    }
}
