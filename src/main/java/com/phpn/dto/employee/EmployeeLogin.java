package com.phpn.dto.employee;

import lombok.experimental.Accessors;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class EmployeeLogin {

    private String email;
    private String password;

}