package com.phpn.repositories;

import com.phpn.dto.product.ProductResult;
import com.phpn.repositories.model.Product;

import com.phpn.repositories.model.ProductInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();


    List<Product> findAllProductByDeleted(boolean deleted);


    @Query(value = "SELECT * FROM v_item_product" , nativeQuery = true)
    List<ProductInfo> findAllProductInfo();


}