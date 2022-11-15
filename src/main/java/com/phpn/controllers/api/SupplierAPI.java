package com.phpn.controllers.api;


import com.phpn.repositories.SupplierRepository;
import com.phpn.repositories.model.Supplier;
import com.phpn.services.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/supplier")
public class SupplierAPI {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Supplier> suppliers = supplierRepository.findAll();

        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(supplierService.findById(id), HttpStatus.OK);
    }



}