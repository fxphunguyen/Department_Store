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
                .setAddress(customerResult.getLocationRegion().getAddress())
                .setWardId(customerResult.getLocationRegion().getWardId())
                .setWardName(customerResult.getLocationRegion().getWardName())
                .setDistrictId(customerResult.getLocationRegion().getDistrictId())
                .setDistrictName(customerResult.getLocationRegion().getDistrictName())
                .setProvinceId(customerResult.getLocationRegion().getProvinceId())
                .setProvinceName(customerResult.getLocationRegion().getProvinceName());
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

    public LocationRegion toLocationRegion(CustomerResult customerResult) {
        LocationRegion locationRegion = locationRegionRepository.findById(customerResult.getLocationRegionId()).get();
        return locationRegion
                .setAddress(customerResult.getLocationRegion().getAddress())
                .setWardId(customerResult.getLocationRegion().getWardId())
                .setWardId(customerResult.getLocationRegion().getWardId())
                .setWardName(customerResult.getLocationRegion().getWardName())
                .setDistrictId(customerResult.getLocationRegion().getDistrictId())
                .setDistrictName(customerResult.getLocationRegion().getDistrictName())
                .setProvinceId(customerResult.getLocationRegion().getProvinceId())
                .setProvinceName(customerResult.getLocationRegion().getProvinceName());
    }
}

