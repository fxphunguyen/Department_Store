<<<<<<< HEAD
package com.phpn.mappers.customer;


import com.phpn.dto.shipping_address.CreateShippingAddressParam;
import com.phpn.dto.shipping_address.ShippingAddressResult;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.ShippingAddress;
import org.springframework.stereotype.Component;

@Component
public class ShippingAddressMapper {


    public ShippingAddress toModel(CreateShippingAddressParam createParam) {
        return new ShippingAddress()
                .setId(createParam.getId())
                .setLine1(createParam.getLine1())
                .setLine2(createParam.getLine2())
                .setProvinceId(createParam.getProvinceId())
                .setProvinceName(createParam.getProvinceName())
                .setDistrictId(createParam.getDistrictId())
                .setDistrictName(createParam.getDistrictName())
                .setWardId(createParam.getWardId())
                .setWardName(createParam.getWardName())
                .setCustomerId(createParam.getCustomerId())
                .setSupplierId(createParam.getSupplierId())
                .setDefault(createParam.isDefault());
    }

    public ShippingAddressResult toDTO(ShippingAddress shippingAddress) {
        return new ShippingAddressResult();
    }
}
=======
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
>>>>>>> 34d69be39a60886a08558dba536a01fe4f640a7d
