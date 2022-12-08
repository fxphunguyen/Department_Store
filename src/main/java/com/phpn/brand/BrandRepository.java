package com.phpn.brand;

import vn.fx.qh.sapo.entities.product.*;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {}