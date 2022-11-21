package com.phpn.dto.supplier;

import com.phpn.repositories.model.Employee;
import com.phpn.repositories.model.LocationRegion;
import com.phpn.repositories.model.SupplierStatus;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SupplierResult {

    private Integer id;
    private String supplierCode;
    private String name;
    private String email;
    private String phone;
    private SupplierStatus status;
    private String description;
    private Employee employee;
    private Integer employeeId;
    private LocationRegion locationRegion;
    private Integer locationRegionId;
    private String createAt;
    private String updateAt;

    private String employeeName;

}