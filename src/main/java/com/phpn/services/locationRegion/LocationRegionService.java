package com.phpn.services.locationRegion;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.dto.localtionRegion.LocationRegionResult;
import com.phpn.repositories.model.LocationRegion;

import java.util.List;

public interface LocationRegionService {
    List<LocationRegionResult> findAllLocaRegion();

}
