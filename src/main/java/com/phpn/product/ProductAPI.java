package com.phpn.product;

import com.phpn.product.dto.ProductItemResult;
import com.phpn.product.dto.ProductResult;
import com.phpn.product.dto.ProductShortParam;
import com.phpn.product.dto.ProductWithImageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vn.fx.qh.sapo.entities.product.Product;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductAPI {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }


    public ResponseEntity<?> getAllProduct(Pageable pageable){
        Page<Product> products;
        products = productService.findAll(pageable);
        List<Product> productList = products.getContent();
        Long totalItem = products.getTotalElements();
        int totalPage = products.getTotalPages();
       List<ProductItemResult> productItemResults = new ArrayList<>();
       for(Product product : productList){
           productItemResults.add(productMapper.toDTOPage(product));
       }
        return new ResponseEntity<>(productItemResults, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        ProductResult productResult = productService.findById(id);
        return new ResponseEntity<>(productResult, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductWithImageParam productWithImageParam) {
        System.out.println(productWithImageParam);
        return new ResponseEntity<>(productService.create(productWithImageParam), HttpStatus.OK);
    }

    @PostMapping("/create-short")
    public ResponseEntity<?> create(@RequestBody ProductShortParam productShortParam) {
        productService.createShortProduct(productShortParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}