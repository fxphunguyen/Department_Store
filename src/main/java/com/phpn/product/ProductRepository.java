package com.phpn.product;

import com.phpn.product.dto.ProductResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.spel.ast.Literal;
import vn.fx.qh.sapo.entities.product.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Status;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAllByTitleContaining(String title, Pageable pageable);
    @Query("SELECT p FROM Product AS p WHERE p.categoryId = 1 AND p.title like 'ao'")
    Page<Product> findAllByCategoryContainingAndTitleContaining(Integer category, String title, Pageable pageable);
    @Query("SELECT p FROM Product AS p WHERE p.categoryId = 1")
    Page<Product> findAllByCategoryContaining(Integer category, Pageable pageable);

//    Page<Product> findAllByBrandContainingAndTitleContaining(Brand brand, String title, Pageable pageable);
//
//    Page<Product> findAllByStatusContainingAndTitleContaining(String status, String title, Pageable pageable);
}