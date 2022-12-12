package com.phpn.product;

import com.phpn.product.dto.ProductResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fx.qh.sapo.entities.product.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAllByTitleContaining(String title, Pageable pageable);
}