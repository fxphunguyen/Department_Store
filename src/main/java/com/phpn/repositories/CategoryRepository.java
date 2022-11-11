package com.phpn.repositories;

import com.phpn.dto.localtionRegion.LocationRegionResult;
import com.phpn.repositories.model.Category;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    LocationRegionResult findById(Long id);
}