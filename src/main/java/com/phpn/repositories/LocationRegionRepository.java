package com.phpn.repositories;


import com.phpn.repositories.model.LocationRegion;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface LocationRegionRepository extends JpaRepository<LocationRegion, Integer> {
//    SELECT max(id) FROM `ph-pn`.location_regions

    @Query("SELECT max(id) FROM LocationRegion ")
   LocationRegion  findMaxIdCustomer();
}