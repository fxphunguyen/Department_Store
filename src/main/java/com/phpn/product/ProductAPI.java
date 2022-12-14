package com.phpn.product;

import com.phpn.brand.BrandService;
import com.phpn.category.CategoryService;
import com.phpn.product.dto.ProductResult;
import com.phpn.product.dto.ProductShortParam;
import com.phpn.product.dto.CreateProductParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/{pageNo}/{pageSize}/{search}/{categoryId}/{brandId}/{status}")
    public ResponseEntity<?>getAllProductPageNoCategory(@PathVariable Integer pageNo,
                                                        @PathVariable Integer pageSize,
                                                        @PathVariable String search,
                                                        @PathVariable Integer categoryId,
                                                        @PathVariable Integer brandId,
                                                        @PathVariable String status
    )
    {
        return new ResponseEntity<>(productService.getAllProductItemPage(pageNo, pageSize,search, categoryId, brandId, status), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/brands")
    public ResponseEntity<?> getAllBrands(){
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

}