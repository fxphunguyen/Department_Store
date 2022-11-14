package com.phpn.dto.customer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.DecimalMin;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CustomerParam {

    private Integer id;

    private String customerCode;

    private String name;

    private String phone;

    private String customerGroup;

    private String email;

    private String birthday;

    private String status;

    private String createAt;

    private String updateAt;

    private Integer employeeId;

    private Integer locationRegionId;


}
