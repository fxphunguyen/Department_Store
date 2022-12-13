package com.phpn.product;


import com.phpn.product.dto.*;
import com.phpn.product.dto.ProductCreate;
import com.phpn.product.dto.ProductResult;
import com.phpn.product.dto.ProductShortParam;
import com.phpn.product.dto.CreateProductParam;
import vn.fx.qh.sapo.entities.product.Product;
import java.util.List;
import java.util.Map;

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

    Map<String, Object> getAllProductItemPage(Integer pageNo, Integer pageSize, String title, Integer categoryId, Integer brandId, String status);
}
