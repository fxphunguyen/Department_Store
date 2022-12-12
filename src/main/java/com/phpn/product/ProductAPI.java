package com.phpn.product;

import com.phpn.product.dto.ProductResult;
import com.phpn.product.dto.ProductShortParam;
import com.phpn.product.dto.CreateProductParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/products")
public class ProductAPI {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;

//    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }


//    @GetMapping()
//    @Transactional(readOnly = true)
//    public ResponseEntity<?> showAllProduct() {
//        List<ProductResult> productResults = productService.showAllProduct();
//        return new ResponseEntity<>(productResults, HttpStatus.OK);
//    }



    @GetMapping("/{pageNo}/{pageSize}/{search}")
    public ResponseEntity<?> getAllProductPageNo(@PathVariable Integer pageNo,
                                                 @PathVariable Integer pageSize,
                                                 @PathVariable String search)
    {
        return new ResponseEntity<>(productService.getAllProductItemPage(pageNo, pageSize, search), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        ProductResult productResult = productService.findById(id);
        return new ResponseEntity<>(productResult, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateProductParam productWithImageParam) {
        ProductResult productResult = productService.create(productWithImageParam);
        System.out.println(productResult);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/create-short")
    public ResponseEntity<?> create(@RequestBody ProductShortParam productShortParam) {
        productService.createShortProduct(productShortParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}