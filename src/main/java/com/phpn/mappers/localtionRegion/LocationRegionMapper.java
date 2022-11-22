package com.phpn.mappers.localtionRegion;


import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.locationRegion.LocationRegionCreate;
import com.phpn.dto.locationRegion.LocationRegionResult;
import com.phpn.repositories.model.LocationRegion;
import org.springframework.stereotype.Component;

@Component
public class LocationRegionMapper {

    public LocationRegionResult toDTO(LocationRegion locationRegion) {
        return new LocationRegionResult()
                .setId(locationRegion.getId())
                .setAddress(locationRegion.getAddress())
                .setWardId(locationRegion.getWardId())
                .setWardName(locationRegion.getWardName())
                .setDistrictId(locationRegion.getDistrictId())
                .setDistrictName(locationRegion.getDistrictName())
                .setProvinceId(locationRegion.getProvinceId())
                .setProvinceName(locationRegion.getProvinceName());
        }

    public LocationRegion toModel(LocationRegionCreate locationRegionCreate){
        return new LocationRegion()
                .setId(0)
                .setAddress(locationRegionCreate.getAddress())
                .setWardId(locationRegionCreate.getWardId())
                .setWardName(locationRegionCreate.getWardName())
                .setDistrictId(locationRegionCreate.getDistrictId())
                .setDistrictName(locationRegionCreate.getDistrictName())
                .setProvinceId(locationRegionCreate.getProvinceId())
                .setProvinceName(locationRegionCreate.getProvinceName());
    }

    public LocationRegionCreate toModel(LocationRegion locationRegion) {
        return new LocationRegionCreate()
                .setId(0)
                .setAddress(locationRegion.getAddress())
                .setWardId(locationRegion.getWardId())
                .setWardName(locationRegion.getWardName())
                .setDistrictId(locationRegion.getDistrictId())
                .setDistrictName(locationRegion.getDistrictName())
                .setProvinceId(locationRegion.getProvinceId())
                .setProvinceName(locationRegion.getProvinceName());
    }
    }

