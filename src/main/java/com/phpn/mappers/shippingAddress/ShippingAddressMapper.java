package com.phpn.mappers.shippingAddress;


import com.phpn.dto.shipping_address.CreateShippingAddressParam;
import com.phpn.dto.shipping_address.ShippingAddressResult;
import com.phpn.repositories.model.ShippingAddress;
import org.springframework.stereotype.Component;

@Component
public class ShippingAddressMapper {


    public ShippingAddressResult toDTO(ShippingAddress shippingAddress) {
        return new ShippingAddressResult()
                .setId(shippingAddress.getId())
                .setAddress(shippingAddress.getLine1())
                .setCustomerId(shippingAddress.getCustomerId())
                .setWardId(shippingAddress.getWardId())
                .setWardName(shippingAddress.getWardName())
                .setDistrictId(shippingAddress.getDistrictId())
                .setDistrictName(shippingAddress.getDistrictName())
                .setProvinceId(shippingAddress.getProvinceId())
                .setProvinceName(shippingAddress.getProvinceName())
                .setZipCode(shippingAddress.getZipCode())
                .setEmail(shippingAddress.getEmail())
                .setMobile(shippingAddress.getMobile());

    }


        public ShippingAddress toModel(CreateShippingAddressParam createParam) {
        return new ShippingAddress()
                .setCustomerId(createParam.getCustomerId())
                .setId(createParam.getId())
                .setWardId(createParam.getWardId())
                .setWardName(createParam.getWardName())
                .setDistrictId(createParam.getDistrictId())
                .setDistrictName(createParam.getDistrictName())
                .setProvinceId(createParam.getProvinceId())
                .setProvinceName(createParam.getProvinceName());


    }
}
