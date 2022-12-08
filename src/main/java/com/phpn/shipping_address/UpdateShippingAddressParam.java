package com.phpn.shipping_address;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UpdateShippingAddressParam {

    private Integer Id;

    private String address;

    private Integer wardId;

    private String wardName;

    private Integer districtId;

    private String districtName;

    private Integer provinceId;

    private String provinceName;

    private Integer customerId;
    
    private Integer supplierId;


}
