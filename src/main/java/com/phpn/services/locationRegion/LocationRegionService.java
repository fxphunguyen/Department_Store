package com.phpn.services.locationRegion;

import com.phpn.dto.localtionRegion.LocationRegionResult;
import com.phpn.repositories.model.LocationRegion;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface LocationRegionService {
    LocationRegionResult findById(Integer id);



}
