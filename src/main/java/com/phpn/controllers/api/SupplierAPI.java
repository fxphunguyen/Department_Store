package com.phpn.controllers.api;

import java.util.List;
import lombok.RequiredArgsConstructor;

import com.phpn.dto.suppliers.SupplierResult;
import com.phpn.services.suppliers.SupplierService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/suppliers")
public class SupplierAPI {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<SupplierResult>> findAll() {
        return new ResponseEntity<>(supplierService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}/histories")
    public ResponseEntity<SupplierResult> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(supplierService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        supplierService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}