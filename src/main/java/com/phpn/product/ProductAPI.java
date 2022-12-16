package com.phpn.product;

import com.phpn.brand.BrandService;
import com.phpn.category.CategoryService;
import com.phpn.product.dto.CreateProductParam;
import com.phpn.product.dto.ProductResult;
import com.phpn.product.dto.ProductShortParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/api/products")
public class
ProductAPI {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BrandService brandService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ProductResult> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);

//        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }


    @GetMapping("getAllProductPage")
    public ResponseEntity<?> getAllProductPage(@RequestParam(defaultValue = "0") Integer pageNo,
                                               @RequestParam(defaultValue = "10") Integer pageSize) {
        //Lan sau de nghi anh khong comment code ham dang chay___ CCCCCUUUUUU
        // return new ResponseEntity<>(productService.getAllProductItemPage(pageNo, pageSize), HttpStatus.OK);
        return null;
    }

    @GetMapping("/page")
    public ResponseEntity<?> getAllProductPageNoCategory(@RequestParam HashMap<String, String> hashMap)
    {
       return new ResponseEntity<>(productService.getAllProductItemPage(
               Integer.valueOf(hashMap.get("pageNo")),
               Integer.valueOf(hashMap.get("pageSize")),
               hashMap.get("search"),
               Integer.valueOf(hashMap.get("categoryId")),
               Integer.valueOf(hashMap.get("brandId")),
               hashMap.get("status")),
               HttpStatus.OK
       );
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/brands")
    public ResponseEntity<?> getAllBrands() {
        return new ResponseEntity<>(brandService.findAll(), HttpStatus.OK);
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
        return new ResponseEntity<>(productResult, HttpStatus.CREATED);
    }

    @PostMapping("/create-short")
    public ResponseEntity<?> create(@RequestBody ProductShortParam productShortParam) {
        productService.createShortProduct(productShortParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateStatusAvailable")
    public ResponseEntity<?> updateStatusAvailable(@RequestBody List<String> arrayIdProduct) {
        productService.saveChangeStatusToAvailable(arrayIdProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateStatusUnavailable")
    public ResponseEntity<?> updateStatusUnavailable(@RequestBody List<String> arrayIdProduct) {
        productService.saveChangeStatusToUnavailable(arrayIdProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}