package com.phpn.product;

import com.phpn.product.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.spel.ast.Literal;
import vn.fx.qh.sapo.entities.product.Category;
import vn.fx.qh.sapo.entities.product.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {

    List<ProductResult> findAll();

    ProductResult findById(Integer id);

    ProductDetailResult findDetailById(Integer id);

    List<ProductResult> findAllProductByDeleted(boolean deleted);

    ProductResult findByIdProduct(Integer id);

//    Product create(ProductWithImageParam productWithImageParam);
//
//    Product createShortProduct(ProductShortParam productShortParam);
    Product createProduct(ProductCreate productCreate);

    ProductResult create(CreateProductParam productWithImageParam);

    ProductResult createShortProduct(ProductShortParam productShortParam);


    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByTitleContaining(String title, Pageable pageable);

    Map<String, Object> getAllProductItemPage(Integer pageNo, Integer pageSize, String title);

    Map<String, Object> getAllProductItemPageByCategoryContaining(Integer pageNo, Integer pageSize, Integer catagoryId);

}
