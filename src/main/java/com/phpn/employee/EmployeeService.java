package com.phpn.employee;

//import org.springframework.security.core.userdetails.UserDetailsService;

import com.phpn.employee.dto.EmployeeResult;

import java.util.List;
//import java.util.Optional;
//
//import com.phpn.repositories.model.Employee;
//import com.phpn.employee.dto.EmployeeParam;


public interface EmployeeService {

    List<EmployeeResult> findAll();

    EmployeeResult findById(Integer id);

//    Employee getByEmail(String email);
//
//    EmployeeResult findByEmail(String email);
//
//    Optional<Employee> findEmployeeById(Integer id);
//
//    Boolean existsByEmail(String email);

}