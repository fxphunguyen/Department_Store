package com.phpn.product;

import com.phpn.product.dto.ProductCreate;
import com.phpn.product.dto.ProductResult;
import com.phpn.product.dto.ProductShortParam;
import com.phpn.product.dto.CreateProductParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fx.qh.sapo.entities.product.Product;

import java.util.List;

public interface ProductService {

    List<ProductResult> findAll();

    ProductResult findById(Integer id);


    List<ProductResult> findAllProductByDeleted(boolean deleted);

    ProductResult findByIdProduct(Integer id);

//    Product create(ProductWithImageParam productWithImageParam);
//
//    Product createShortProduct(ProductShortParam productShortParam);
    Product createProduct(ProductCreate productCreate);

    ProductResult create(CreateProductParam productWithImageParam);

    ProductResult createShortProduct(ProductShortParam productShortParam);


    Page<Product> findAll(Pageable pageable);

    public List<?> getAllProdcutItemPage(Integer pageNo, Integer pageSize);

}
