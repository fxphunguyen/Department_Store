package com.phpn.category;

import vn.fx.qh.sapo.entities.product.*;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}