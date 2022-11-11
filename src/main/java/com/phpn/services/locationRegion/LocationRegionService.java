package com.phpn.services.locationRegion;

import com.phpn.dto.category.CategoryResult;
import com.phpn.dto.localtionRegion.LocationRegionResult;
import com.phpn.repositories.model.LocationRegion;

import java.util.List;

public interface LocationRegionService {
    List<CategoryResult> findAllLocaRegion();


    LocationRegionResult createLocationRegion (LocationRegion locationRegion );

    LocationRegionResult findById(Long id);


}
