//package com.phpn.mappers.customer;
//
//
//import com.phpn.dto.shipping_address.CreateShippingAddressParam;
//import com.phpn.repositories.model.Customer;
//import com.phpn.repositories.model.ShippingAddress;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ShippingAddressMapper {
//
//
//    public ShippingAddress toModel(CreateShippingAddressParam createParam) {
//        return new ShippingAddress()
//                .setCustomerId(createParam.getCustomerId());
////                .setId(customerResult.getId())
////                .setCustomerCode(customerResult.getCustomerCode())
////                .setName(customerResult.getName())
////                .setPhone(customerResult.getPhone())
////                .setCustomerGroup(customerResult.getCustomerGroup())
////                .setCustomerGender(customerResult.getCustomerGender())
////                .setEmail(customerResult.getEmail())
////                .setBirthday(customerResult.getBirthday())
////                .setCustomerStatus(customerResult.getCustomerStatus())
////                .setUpdateAt(customerResult.getUpdateAt())
////                .setUpdateAt(java.time.LocalDateTime.now().toString())
////                .setDeleted(true);
//
//    }
//
//
//}