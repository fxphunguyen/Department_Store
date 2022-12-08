package com.phpn.repositories;

import com.phpn.repositories.model.PaymentOrder;
import com.phpn.repositories.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, String> {
}
