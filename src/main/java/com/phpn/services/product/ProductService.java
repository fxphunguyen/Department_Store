package com.phpn.services.product;

import java.util.List;

import com.phpn.dto.product.ProductResult;
import com.phpn.dto.product.ProductShortParam;
import com.phpn.dto.product.ProductCreate;
import com.phpn.dto.product.ProductWithImageParam;
import com.phpn.repositories.model.Product;

public interface ProductService {

    List<ProductResult> findAll();

    List<ProductResult>  showAllProduct();

    List<ProductResult> findAllProductByDeleted(boolean deleted);

    ProductResult findByIdProduct(Integer id);

    Product create(ProductWithImageParam productWithImageParam);

    Product createShortProduct(ProductShortParam productShortParam);
    Product createProduct(ProductCreate productCreate);
    List<ProductResult> getAllProductListResult();
}
