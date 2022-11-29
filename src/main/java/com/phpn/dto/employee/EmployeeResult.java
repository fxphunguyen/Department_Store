package com.phpn.dto.employee;

import lombok.experimental.Accessors;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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