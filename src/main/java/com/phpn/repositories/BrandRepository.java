package com.phpn.repositories;

import com.phpn.repositories.model.Brand;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {}