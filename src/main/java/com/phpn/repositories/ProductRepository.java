package com.phpn.repositories;

import com.phpn.dto.product.ProductResult;
import com.phpn.repositories.model.Product;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();


    List<Product> findAllProductByDeleted(boolean deleted);


}