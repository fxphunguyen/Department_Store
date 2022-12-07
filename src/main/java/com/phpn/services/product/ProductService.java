package com.phpn.services.product;

import java.util.List;

import com.phpn.dto.product.ProductCreate;
import com.phpn.dto.product.ProductListResult;
import com.phpn.dto.product.ProductParam;
import com.phpn.dto.product.ProductResult;
import com.phpn.dto.product.ProductWithImageParam;
import com.phpn.repositories.model.Product;

public interface ProductService {

    List<ProductResult> findAll();

    List<ProductResult>  showAllProduct();

    List<ProductResult> findAllProductByDeleted(boolean deleted);

    ProductResult findByIdProduct(Integer id);

    Product create(ProductWithImageParam productWithImageParam);

    Product createProduct(ProductCreate productCreate);
    List<ProductListResult> getAllProductListResult();
}
