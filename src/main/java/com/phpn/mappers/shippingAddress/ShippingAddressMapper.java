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
                .setMobile(shippingAddress.getMobile())
                .setIsDefault(shippingAddress.getIsDefault());

    }


        public ShippingAddress toModel(CreateShippingAddressParam createParam) {
        return new ShippingAddress()
                .setLine1(createParam.getAddress())
                .setCustomerId(createParam.getCustomerId())
                .setWardId(createParam.getWardId())
                .setWardName(createParam.getWardName())
                .setDistrictId(createParam.getDistrictId())
                .setDistrictName(createParam.getDistrictName())
                .setProvinceId(createParam.getProvinceId())
                .setProvinceName(createParam.getProvinceName())
                .setZipCode(createParam.getZipCode())
                .setEmail(createParam.getEmail())
                .setFullName(createParam.getFullName())
                .setMobile(createParam.getMobile());



    }
}
