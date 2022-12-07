package com.phpn.dto.customer;

import com.phpn.dto.employee.EmployeeResult;
import lombok.*;
import lombok.experimental.Accessors;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CustomerOrderResult {

    private Integer id;

    private String customerCode;

    private String name;

    private String phone;

//    private Integer locationRegionId;

//    private LocationRegionResult locationRegion;

    private Integer employeeId;

    private EmployeeResult employee;

    private Boolean deleted;


}

