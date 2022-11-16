package com.phpn.services.locationRegion;

import com.phpn.dto.locationRegion.LocationRegionResult;
import com.phpn.repositories.model.LocationRegion;

public interface LocationRegionService {



    LocationRegionResult findById(Integer id);

    LocationRegion save(LocationRegion locationRegion);



}
