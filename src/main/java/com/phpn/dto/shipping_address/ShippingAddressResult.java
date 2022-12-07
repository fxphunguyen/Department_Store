package com.phpn.dto.shipping_address;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String line1;

    private String line2;

    private Integer wardId;

    private String wardName;

    private Integer districtId;

    private String districtName;

    private Integer provinceId;

    private String provinceName;

    private String mobile;

    private String email;

    private String zipCode;

    private boolean isDefault;


    public ShippingAddressResult setDefault(boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    @JsonIgnore
    public boolean isDefault() {
        return isDefault;
    }

}
