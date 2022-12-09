package com.phpn.supplier;

import vn.fx.qh.sapo.entities.product.supplier.*;

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
public class SupplierParam {

    private Integer id;
    private String supplierCode;
    private String name;
    private String email;
    private String phone;
    private SupplierStatus supplierStatus;
    private String description;
    private Integer employeeId;
    private Integer paymentMethodId;
    private Integer locationRegionId;
    private String createAt;
    private String updateAt;

}