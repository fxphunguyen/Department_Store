package com.phpn.dto.supplier;

import com.phpn.repositories.model.SupplierStatus;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SupplierCreateParam {

    private String supplierCode;
    private String name;
    private String email;
    private String phone;
    private SupplierStatus status;
    private String description;
    private Integer employeeId;
    private Integer locationRegionId;

}