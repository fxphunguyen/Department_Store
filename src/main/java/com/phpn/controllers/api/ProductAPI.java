package com.phpn.controllers.api;

import com.phpn.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductAPI {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<?> showList() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

}