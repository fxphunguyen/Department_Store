package com.phpn.services.locationRegion;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.localtionRegion.LocationRegionResult;
import com.phpn.dto.localtionRegion.LocationRegionCreate;
import com.phpn.repositories.model.LocationRegion;

public interface LocationRegionService {



    LocationRegionResult findById(Integer id);

    LocationRegion save(LocationRegion locationRegion);



}
