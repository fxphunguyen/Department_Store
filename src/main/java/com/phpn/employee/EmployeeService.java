package com.phpn.employee;

import com.phpn.employee.dto.EmployeeResult;

import java.util.List;



public interface EmployeeService {

    List<EmployeeResult> findAll();

    EmployeeResult findById(Integer id);

}