package com.phpn.services.employee;

import com.phpn.dto.employee.EmployeeResult;
import com.phpn.repositories.model.Customer;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResult> findAll();
}
