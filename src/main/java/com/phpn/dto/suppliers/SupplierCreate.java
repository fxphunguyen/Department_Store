package com.phpn.dto.suppliers;

import com.phpn.repositories.model.SupplierStatus;
import com.phpn.dto.locationRegion.LocationRegionCreate;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SupplierCreate {

    private String supplierCode;
    private String name;
    private String email;
    private String phone;
    private SupplierStatus supplierStatus;
    private String description;
    private Integer employeeId;
    private Integer paymentMethodId;
    private Integer locationRegionId;
    private LocationRegionCreate locationRegionCreate;

}