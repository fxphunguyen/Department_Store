package com.phpn.supplier;

import vn.fx.qh.sapo.entities.product.supplier.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

import java.time.Instant;

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
    private Instant createAt;
    private Instant updateAt;

}