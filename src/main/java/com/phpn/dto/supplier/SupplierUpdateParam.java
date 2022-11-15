package com.phpn.dto.supplier;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SupplierUpdateParam {

    private String supplierCode;
    private String name;
    private String email;
    private String phone;
    private String status;
    private String description;
    private Integer employeeId;
    private Integer locationRegionId;

}