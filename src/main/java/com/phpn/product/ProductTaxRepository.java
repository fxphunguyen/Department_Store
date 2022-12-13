package com.phpn.product;

import vn.fx.qh.sapo.entities.product.tax.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTaxRepository extends JpaRepository<ProductTax, ProductTaxId> {
    List<ProductTax> findAllByProductIdAndTaxType(Integer productId, TaxType taxType);

    List<ProductTax> findAllByProductId(Integer productId);

}
