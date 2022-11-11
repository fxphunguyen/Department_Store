package com.phpn.services.locationRegion;


import com.phpn.dto.category.CategoryResult;
import com.phpn.dto.localtionRegion.LocationRegionResult;
import com.phpn.mappers.CategoryMapper;
import com.phpn.repositories.CategoryRepository;
import com.phpn.repositories.model.LocationRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LocationRegionServiceImpl implements LocationRegionService{

@Autowired
    CategoryRepository categoryRepository;


@Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryResult> findAllLocaRegion() {
        return categoryRepository.findAll()
                .stream()
                .map(createLocationRegion -> categoryMapper.toDTO(createLocationRegion))
                .collect(Collectors.toList());
    }

    @Override
    public LocationRegionResult createLocationRegion(LocationRegion locationRegion) {
        return null;
    }

    @Override
    public LocationRegionResult findById(Long id) {
        return categoryRepository.findById(id);
    }
}
