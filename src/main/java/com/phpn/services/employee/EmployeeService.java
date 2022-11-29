package com.phpn.services.employee;

import java.util.List;
import com.phpn.dto.employee.EmployeeResult;

public interface EmployeeService {

    List<EmployeeResult> findAll();

    EmployeeResult findById(Integer id);

}