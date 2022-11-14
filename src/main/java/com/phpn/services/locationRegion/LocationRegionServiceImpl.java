package com.phpn.services.locationRegion;


import com.phpn.dto.localtionRegion.LocationRegionResult;
import com.phpn.exceptions.NotFoundException;
import com.phpn.mappers.localtionRegion.LocaltionRegionMapper;
import com.phpn.repositories.LocationRegionRepository;
import com.phpn.repositories.model.LocationRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationRegionServiceImpl implements LocationRegionService{

    @Autowired
    LocaltionRegionMapper localtionRegionMapper;

    @Autowired
    LocationRegionRepository locationRegionRepository;

    @Override
    public LocationRegionResult findById(Integer id) {
        Optional<LocationRegion> locationRegionOptional = locationRegionRepository.findById(id);
        if (locationRegionOptional.isPresent()){
            throw new NotFoundException("Không tìm thấy id phù  hợp" + id);
        }
        return localtionRegionMapper.toDTO(locationRegionOptional.get());
    }
}
