package com.phpn.product;

import com.phpn.product.dto.ProductResult;
import vn.fx.qh.sapo.entities.product.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    @Query(value = "SELECT * FROM `ph-pn`.v_item_product", nativeQuery = true)
    List<ProductInfo> findAllProductInfo();

    @Query(value = "call getAllProductList()",nativeQuery = true)
    List<ProductResult> getAllProductListResult();
}