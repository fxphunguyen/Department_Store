package com.phpn.dto.suppliers;

import com.phpn.dto.employee.EmployeeResult;
import com.phpn.dto.locationRegion.LocationRegionResult;
import com.phpn.repositories.model.SupplierStatus;

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
public class SupplierResult {

    private Integer id;
    private String supplierCode;
    private String name;
    private String email;
    private String phone;
    private SupplierStatus supplierStatus;
    private String description;
    private Integer employeeId;
    private Integer locationRegionId;
    private EmployeeResult employeeResult;
    private LocationRegionResult locationRegionResult;
    private String createAt;
    private String updateAt;

}