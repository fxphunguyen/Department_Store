package com.phpn.controllers.api;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.product.ProductParam;
import com.phpn.dto.product.ProductResult;
import com.phpn.repositories.model.Product;
import com.phpn.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<?> showAllProduct(){
        List<ProductResult> productResults = productService.showAllProduct();
        return  new ResponseEntity<>(productResults, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        ProductResult productResult = productService.findByIdProduct(id);
        return new ResponseEntity<>(productResult, HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<?> createProduct(@RequestBody ProductParam productParam){
        Product product = productService.create(productParam);
        return  new ResponseEntity<>(product, HttpStatus.OK);
    }

}