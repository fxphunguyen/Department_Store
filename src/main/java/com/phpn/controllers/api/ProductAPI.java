package com.phpn.controllers.api;

import com.phpn.dto.product.ProductResult;
import com.phpn.repositories.ProductRepository;
import com.phpn.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductAPI {

    @Autowired
    private ProductService productService;

    @GetMapping("/show_list")
    public ResponseEntity<?> showList(boolean deleted) {
        List<ProductResult> productResults = productService.findAllProductByDeleted(deleted);
        return new ResponseEntity<>(productResults, HttpStatus.OK);
    }

}