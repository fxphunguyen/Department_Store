package com.phpn.dto.shipping_address;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class CreateShippingAddressParam {

    private Integer Id;

    private String address;

    private String line1;

    private String line2;

    private Integer wardId;

    private String wardName;

    private Integer districtId;

    private String districtName;

    private Integer provinceId;

    private String provinceName;

    private Integer customerId;

    private String email;

    private String zipCode;

    private  String fullName;

    private  String mobile;


    private Integer supplierId;

    private Boolean isDefault;

    public void setDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public boolean isDefault() {
        return isDefault;
    }
}
