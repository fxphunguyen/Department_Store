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
                .setDistricId(locationRegion.getId())
                .setDistrictName(locationRegion.getDistrictName())
                .setProvinceId(locationRegion.getProvinceId())
                .setProvinceName(locationRegion.getProvinceName());
        }
        public LocationRegion toModel(CustomerCreate customerCreate){
            return new LocationRegion()
                    .setId(customerCreate.getId())
                    .setAddress(customerCreate.getLocationReionCreate().getAddress())
                    .setWardId(customerCreate.getLocationReionCreate().getWardId())
                    .setWardName(customerCreate.getLocationReionCreate().getWardName())
                    .setDistrictId(customerCreate.getLocationReionCreate().getDistrictId())
                    .setDistrictName(customerCreate.getLocationReionCreate().getDistrictName())
                    .setProvinceId(customerCreate.getLocationReionCreate().getProvinceId())
                    .setProvinceName(customerCreate.getLocationReionCreate().getProvinceName());
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
    }

