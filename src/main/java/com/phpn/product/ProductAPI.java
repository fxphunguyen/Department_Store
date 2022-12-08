package com.phpn.product;

import com.phpn.product.dto.ProductResult;
import com.phpn.product.dto.ProductShortParam;
import com.phpn.product.dto.ProductWithImageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vn.fx.qh.sapo.entities.product.Product;


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

    @GetMapping()
    @Transactional(readOnly = true)
    public ResponseEntity<?> showAllProduct() {
        List<ProductResult> productResults = productService.showAllProduct();
        return new ResponseEntity<>(productResults, HttpStatus.OK);
    }


   // C0522k1
//    @GetMapping("")
    public ResponseEntity<?> getAllProduct(){
        List<ProductResult> products = productService.getAllProductListResult();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        ProductResult productResult = productService.findByIdProduct(id);
        return new ResponseEntity<>(productResult, HttpStatus.OK);
    }

//    @PostMapping("/create")
//    public ResponseEntity<?> createProduct(@RequestBody ProductParam productParam){
//        Product product = productService.create(productParam);
//        return  new ResponseEntity<>(product, HttpStatus.OK);
//    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductWithImageParam productWithImageParam){
        System.out.println(productWithImageParam);

        Product product = productService.create(productWithImageParam);
        return  new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/create-short")
    public ResponseEntity<?> createProduct(@RequestBody ProductShortParam productShortParam){
        System.out.println(productShortParam);
         productService.createShortProduct(productShortParam);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/showProductInfo")
    public  ResponseEntity<?> showProductInfo(){
        return  new ResponseEntity<>( productService.findAll(), HttpStatus.OK);
    }
}