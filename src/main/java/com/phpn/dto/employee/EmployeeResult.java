package com.phpn.dto.employee;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class EmployeeResult {
    private Integer id;

    private String name;

    private String email;

    private String birthday;

    private Integer locationRegionId;

    private String gender;

}
