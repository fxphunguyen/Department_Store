package com.phpn.services.product;

import java.util.List;
import java.util.Optional;

import com.phpn.dto.product.ProductCreateParam;
import com.phpn.dto.product.ProductParam;
import com.phpn.dto.product.ProductResult;
import com.phpn.repositories.model.Product;

public interface ProductService {

    List<ProductResult> findAll();

    List<ProductResult>  showAllProduct();

    List<ProductResult> findAllProductByDeleted(boolean deleted);


    ProductResult findByIdProduct(Integer id);
    Product create(ProductParam productParam);

}
