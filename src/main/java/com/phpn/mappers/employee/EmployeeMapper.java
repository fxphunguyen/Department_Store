package com.phpn.mappers.employee;

import org.springframework.stereotype.Component;

import com.phpn.repositories.model.Employee;
import com.phpn.dto.employee.EmployeeParam;
import com.phpn.dto.employee.EmployeeResult;
import com.phpn.dto.employee.EmployeeRResult;

@Component
public class EmployeeMapper {

    public EmployeeResult toDTO(Employee employee) {
        return new EmployeeResult()
        .setId(employee.getId())
        .setName(employee.getName())
        .setEmail(employee.getEmail())
        .setBirthday(employee.getBirthday())
        .setGender(employee.getGender())
        .setLocationRegionId(employee.getLocationRegionId());
    }

    public EmployeeRResult toRDTO(Employee employee) {
        return new EmployeeRResult()
        .setId(employee.getId())
        .setName(employee.getName());
    }


    public Employee toModel(EmployeeParam employeeParam) {
        return new Employee()
        .setId(employeeParam.getId())
        .setName(employeeParam.getName())
        .setEmail(employeeParam.getEmail())
        .setPhone(employeeParam.getPhone())
        .setPassword(employeeParam.getPassword())
        .setBirthday(employeeParam.getBirthday())
        .setGender(employeeParam.getGender());
    }

}