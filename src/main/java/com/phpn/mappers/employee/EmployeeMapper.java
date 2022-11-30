package com.phpn.mappers.employee;


import com.phpn.dto.employee.EmployeeParam;
import com.phpn.dto.employee.EmployeeRResult;
import com.phpn.dto.employee.EmployeeResult;
import com.phpn.mappers.localtionRegion.LocationRegionMapper;
import com.phpn.repositories.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.phpn.repositories.model.Employee;
import com.phpn.dto.employee.EmployeeParam;
import com.phpn.dto.employee.EmployeeResult;
import com.phpn.dto.employee.EmployeeRResult;

@Component
public class EmployeeMapper {

    @Autowired
    private LocationRegionMapper locationRegionMapper;

    public EmployeeResult toDTO(Employee employee) {
        return new EmployeeResult()
       .setId(employee.getId())
                .setName(employee.getName())
                .setEmail(employee.getEmail())
                .setBirthday(employee.getBirthday())
                .setLocationRegionId(employee.getLocationRegionId())
                .setLocationRegion(locationRegionMapper.toDTO(employee.getLocationRegion()))
                .setGender(employee.getGender());
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