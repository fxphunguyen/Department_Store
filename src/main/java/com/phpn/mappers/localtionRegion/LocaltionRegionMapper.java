package com.phpn.mappers.localtionRegion;


import com.phpn.dto.localtionRegion.LocationRegionParam;
import com.phpn.dto.localtionRegion.LocationRegionResult;
import com.phpn.repositories.model.LocationRegion;
import org.springframework.stereotype.Component;

@Component
public class LocaltionRegionMapper {

    public LocationRegionResult toDTO(LocationRegion locationRegion) {
        return new LocationRegionResult()
                .setId(locationRegion.getId())
                .setAddress(locationRegion.getAddress())
                .setWardId(locationRegion.getWardId())
                .setWardName(locationRegion.getWardName())
                .setDistricId(locationRegion.getId())
                .setDistrictName(locationRegion.getDistrictName())
                .setProvinceId(locationRegion.getProvinceId())
                .setProvinceName(locationRegion.getProvinceName());
        }
    }

