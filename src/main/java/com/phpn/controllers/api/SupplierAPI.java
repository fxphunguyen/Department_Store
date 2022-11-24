package com.phpn.controllers.api;

import java.util.List;
import lombok.RequiredArgsConstructor;

import com.phpn.dto.suppliers.SupplierResult;
import com.phpn.dto.suppliers.SupplierCreate;
import com.phpn.repositories.model.Supplier;
import com.phpn.services.suppliers.SupplierService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody SupplierCreate supplierCreate) {
        supplierCreate.setId(0);
        supplierCreate.setEmployeeId(2);
        System.out.println(supplierCreate);
        Supplier supplier = supplierService.save(supplierCreate);
        return new ResponseEntity<>(supplier,HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        supplierService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}