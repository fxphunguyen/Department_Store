package com.phpn.repositories.product;

import vn.fx.qh.sapo.entities.product.tax.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Integer> {

}
