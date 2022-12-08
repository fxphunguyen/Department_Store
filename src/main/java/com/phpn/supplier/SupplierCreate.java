package com.phpn.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private String description;
    private Integer employeeId;
    private Integer paymentMethodId;


}