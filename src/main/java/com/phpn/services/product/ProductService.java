package com.phpn.services.product;

import java.util.List;

import com.phpn.dto.product.ProductCreateParam;
import com.phpn.dto.product.ProductResult;
import com.phpn.repositories.model.Product;

public interface ProductService {

    List<ProductResult> findAll();

    List<ProductResult> findAllProductByDeleted(boolean deleted);


    Product findById(Integer id);

    Product create(ProductCreateParam productCreateParam);

}
