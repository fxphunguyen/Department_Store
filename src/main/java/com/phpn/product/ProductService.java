package com.phpn.product;

import com.phpn.product.dto.ProductCreate;
import com.phpn.product.dto.ProductResult;
import com.phpn.product.dto.ProductShortParam;
import com.phpn.product.dto.ProductWithImageParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fx.qh.sapo.entities.product.Product;

import java.util.List;

public interface ProductService {

    List<ProductResult> findAll();

    List<ProductResult>  showAllProduct();

    List<ProductResult> findAllProductByDeleted(boolean deleted);

    ProductResult findByIdProduct(Integer id);

    Product create(ProductWithImageParam productWithImageParam);

    Product createShortProduct(ProductShortParam productShortParam);
    Product createProduct(ProductCreate productCreate);
    List<ProductResult> getAllProductListResult();


    Page<Product> findAll(Pageable pageable);

}
