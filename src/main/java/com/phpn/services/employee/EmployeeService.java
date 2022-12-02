package com.phpn.services.employee;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

import com.phpn.repositories.model.Employee;
import com.phpn.dto.employee.EmployeeParam;
import com.phpn.dto.employee.EmployeeResult;

public interface EmployeeService extends UserDetailsService {

    List<EmployeeResult> findAll();

    Employee getByEmail(String email);

    Optional<Employee> findByEmail(String email);

    Optional<EmployeeParam> findEmployeeParamByEmail(String email);

    Optional<Employee> findEmployeeById(Integer id);

    Boolean existsByEmail(String email);

    EmployeeResult findById(Integer id);

}