package com.phpn.repositories;

import com.phpn.repositories.model.ProductTax;
import com.phpn.repositories.model.TaxType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTaxRepository extends JpaRepository<Integer, ProductTax> {
    List<ProductTax> findAllByTaxType(TaxType taxType);
}
