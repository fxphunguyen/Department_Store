package com.phpn.dto.employee;

import com.phpn.dto.locationRegion.LocationRegionResult;
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
public class EmployeeParam {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String birthday;
    private String gender;
    private Integer locationRegionId;

}