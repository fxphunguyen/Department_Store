package com.phpn.mappers.localtionRegion;


import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.dto.locationRegion.LocationRegionCreate;
import com.phpn.dto.locationRegion.LocationRegionResult;
import com.phpn.repositories.LocationRegionRepository;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.LocationRegion;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationRegionMapper {

    @Autowired
    LocationRegionRepository locationRegionRepository;

    public LocationRegionResult toDTO(LocationRegion locationRegion) {
        return new LocationRegionResult()
                .setId(locationRegion.getId())
                .setAddress(locationRegion.getAddress())
                .setWardId(locationRegion.getWardId())
                .setWardName(locationRegion.getWardName())
                .setDistrictId(locationRegion.getId())
                .setDistrictName(locationRegion.getDistrictName())
                .setProvinceId(locationRegion.getProvinceId())
                .setProvinceName(locationRegion.getProvinceName());
    }

    public LocationRegion toModel(LocationRegionCreate locationRegionCreate) {
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

    public LocationRegion toModel(CustomerResult customerResult) {
        return new LocationRegion()
                .setId(customerResult.getLocationRegionId())
                .setAddress(customerResult.getLocationRegionResult().getAddress())
                .setWardId(customerResult.getLocationRegionResult().getWardId())
                .setWardName(customerResult.getLocationRegionResult().getWardName())
                .setDistrictId(customerResult.getLocationRegionResult().getDistrictId())
                .setDistrictName(customerResult.getLocationRegionResult().getDistrictName())
                .setProvinceId(customerResult.getLocationRegionResult().getProvinceId())
                .setProvinceName(customerResult.getLocationRegionResult().getProvinceName());
    }

    public LocationRegionCreate toModel(LocationRegion locationRegion) {
        return new LocationRegionCreate()
                .setId(locationRegion.getId())
                .setAddress(locationRegion.getAddress())
                .setWardId(locationRegion.getWardId())
                .setWardName(locationRegion.getWardName())
                .setDistrictId(locationRegion.getDistrictId())
                .setDistrictName(locationRegion.getDistrictName())
                .setProvinceId(locationRegion.getProvinceId())
                .setProvinceName(locationRegion.getProvinceName());
    }

    public LocationRegion toLocationRegion(LocationRegionResult locationRegionResult,LocationRegion locationRegion) {
        return locationRegion
                .setAddress(locationRegionResult.getAddress())
                .setWardId(locationRegionResult.getWardId())
                .setWardId(locationRegionResult.getWardId())
                .setWardName(locationRegionResult.getWardName())
                .setDistrictId(locationRegionResult.getDistrictId())
                .setDistrictName(locationRegionResult.getDistrictName())
                .setProvinceId(locationRegionResult.getProvinceId())
                .setProvinceName(locationRegionResult.getProvinceName());
    }
}

