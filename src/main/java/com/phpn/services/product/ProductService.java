package com.phpn.services.product;

import java.util.List;

import com.phpn.dto.product.ProductResult;
import com.phpn.repositories.model.Product;

public interface ProductService {

    List<?> findAll();

    Product findById(Integer id);

    Product create(Product product);

}