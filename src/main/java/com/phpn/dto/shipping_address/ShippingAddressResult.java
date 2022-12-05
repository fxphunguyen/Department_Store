package com.phpn.dto.shipping_address;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ShippingAddressResult {

    private Integer Id;

    private Integer customerId;

    private String address;

    private Integer wardId;

    private String wardName;

    private Integer districtId;

    private String districtName;

    private Integer provinceId;

    private String provinceName;

    private String mobile;

    private  String email;

    private String zipCode;

}
