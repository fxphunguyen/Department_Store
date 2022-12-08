package com.phpn.repositories;

import com.phpn.dto.product.ProductListResult;
import com.phpn.repositories.model.Product;

import com.phpn.repositories.model.ProductInfo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();


    List<Product> findAllProductByDeleted(boolean deleted);


    @Query(value = "SELECT * FROM v_item_product" , nativeQuery = true)
    List<ProductInfo> findAllProductInfo();

    @Query(value = "call getAllProductList()",nativeQuery = true)
    List<ProductListResult> getAllProductListResult();

}