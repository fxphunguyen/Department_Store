//package com.phpn.mappers.customer;
//
//
//import com.phpn.customer.CreateShippingAddressParam;
//import com.phpn.customer.ShippingAddressResult;
//import com.phpn.repositories.model.ShippingAddress;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ShippingAddressMapper {
//
//    public ShippingAddress toModel(CreateShippingAddressParam createParam) {
//        return new ShippingAddress()
//                .setId(createParam.getId())
//                .setLine1(createParam.getLine1())
//                .setLine2(createParam.getLine2())
//                .setProvinceId(createParam.getProvinceId())
//                .setProvinceName(createParam.getProvinceName())
//                .setDistrictId(createParam.getDistrictId())
//                .setDistrictName(createParam.getDistrictName())
//                .setWardId(createParam.getWardId())
//                .setWardName(createParam.getWardName())
//                .setCustomerId(createParam.getCustomerId())
//                .setSupplierId(createParam.getSupplierId())
//                .setDefault(createParam.isDefault());
//    }
//
//    public ShippingAddressResult toDTO(ShippingAddress shippingAddress) {
//        return new ShippingAddressResult()
//                .setId(shippingAddress.getId())
//                .setCustomerId(shippingAddress.getCustomerId())
//                .setLine1(shippingAddress.getLine1())
//                .setLine2(shippingAddress.getLine2())
//                .setWardId(shippingAddress.getWardId())
//                .setWardName(shippingAddress.getWardName())
//                .setDistrictId(shippingAddress.getDistrictId())
//                .setDistrictName(shippingAddress.getDistrictName())
//                .setProvinceId(shippingAddress.getProvinceId())
//                .setProvinceName(shippingAddress.getProvinceName())
//                .setMobile(shippingAddress.getMobile())
//                .setZipCode(shippingAddress.getZipCode())
//                .setDefault(shippingAddress.getIsDefault());
//    }
//}
