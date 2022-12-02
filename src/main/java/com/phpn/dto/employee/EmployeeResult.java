package com.phpn.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.experimental.Accessors;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class EmployeeResult {

    private Integer id;
    private String name;
    private String email;
    private String birthday;
    private String gender;
    private Integer locationRegionId;

}
