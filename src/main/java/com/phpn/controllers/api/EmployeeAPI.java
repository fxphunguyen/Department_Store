package com.phpn.controllers.api;

import com.phpn.dto.customer.CustomerResult;
import com.phpn.dto.employee.EmployeeRResult;
import com.phpn.dto.employee.EmployeeResult;
import com.phpn.repositories.EmployeeRepository;
import com.phpn.repositories.model.Employee;
import com.phpn.services.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeAPI {

    @Autowired
    private EmployeeService employeeService;


    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/show_list")
    public ResponseEntity<?> showListEmployee() {
        List<EmployeeResult> employeeResults = employeeService.findAll();
        return new ResponseEntity<>(employeeResults, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> findByIdEmployee(@PathVariable Integer id){
        Employee employee = employeeRepository.findById(id).get();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }



}
