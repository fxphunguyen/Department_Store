package com.phpn.repositories;

import com.phpn.repositories.model.LocationRegion;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LocationRegionRepository extends JpaRepository<LocationRegion, Integer> {}