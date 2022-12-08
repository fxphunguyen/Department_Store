package com.phpn.supplier;

import vn.fx.qh.sapo.entities.product.supplier.*;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {}