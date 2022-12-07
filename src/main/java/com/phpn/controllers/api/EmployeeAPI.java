package com.phpn.controllers.api;


import com.phpn.dto.customer.CustomerResult;
import com.phpn.repositories.EmployeeRepository;
import com.phpn.repositories.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeAPI {

    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public ResponseEntity<?> showListCustomerAll() {
        List<Employee> employees = employeeRepository.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }



}
