package com.phpn.employee;

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
public class EmployeeRResult {

    private Integer id;
    private String name;

}