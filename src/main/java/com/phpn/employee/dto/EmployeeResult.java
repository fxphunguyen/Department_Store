package com.phpn.employee.dto;

import lombok.*;

import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class EmployeeResult {

    private Integer id;
    private String name;
    private String email;
    private String birthday;
    private String gender;


}
