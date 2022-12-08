package com.phpn.customer;

import com.phpn.customer.dto.CreateShippingAddressParam;
import com.phpn.shipping_address.ShippingAddressResult;
import com.phpn.shipping_address.ShippingAddressShowCustomerInfo;
import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.customer.ShippingAddress;

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
                .setShipping(shippingAddress.isShippingAddress())
                .setReceiveBill(shippingAddress.isReceiveBill());

    }


    public ShippingAddress toModel(CreateShippingAddressParam createParam) {
        return new ShippingAddress()
                .setId(0)
                .setLine1(createParam.getLine1())
                .setLine2(createParam.getLine2())
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
                .setMobile(createParam.getMobile())
                .setSupplierId(1);
    }

    public ShippingAddressShowCustomerInfo toCustomerInfo(ShippingAddress shippingAddress) {
        return new ShippingAddressShowCustomerInfo()
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
}
