package com.phpn.dto.customer;

import com.phpn.dto.employee.EmployeeResult;
import com.phpn.dto.locationRegion.LocationRegionResult;
import com.phpn.repositories.model.CustomerGender;
import com.phpn.repositories.model.CustomerGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CustomerOrderResult {

    private Integer id;

    private String customerCode;

    private String name;

    private String phone;

    private Instant updateAt;

    private Integer locationRegionId;

    private Integer employeeId;


    public CustomerOrderResult (String customerCode, String name, String phone, Integer locationRegionId, Integer employeeId) {

        this.customerCode = customerCode;
        this.name = name;
        this.phone = phone;
        this.locationRegionId = locationRegionId;
        this.employeeId = employeeId;

    }
}

