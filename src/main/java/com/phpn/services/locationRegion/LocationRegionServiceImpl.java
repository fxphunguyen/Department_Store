package com.phpn.services.locationRegion;


import com.phpn.dto.localtionRegion.LocationRegionResult;
import com.phpn.repositories.LocationRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocationRegionServiceImpl implements LocationRegionService{


    @Override
    public List<LocationRegionResult> findAllLocaRegion() {
        return null;
    }
}
