package com.phpn.controllers.api;

import com.phpn.repositories.model.Supplier;
import com.phpn.services.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/supplier")
public class SupplierAPI {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(supplierService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(supplierService.findById(id), HttpStatus.OK);
    }

}