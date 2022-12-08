package com.phpn.services.product;

import java.util.List;

import com.phpn.product.dto.ProductResult;
import com.phpn.product.dto.ProductShortParam;
import com.phpn.product.dto.ProductCreate;
import com.phpn.product.dto.ProductWithImageParam;
import vn.fx.qh.sapo.entities.Product;

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
