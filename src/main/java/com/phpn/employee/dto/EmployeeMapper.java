package com.phpn.employee.dto;


import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.employee.*;

@Component
public class EmployeeMapper {

    public EmployeeResult toDTO(Employee employee) {
        return new EmployeeResult()
                .setId(employee.getId())
                .setName(employee.getName())
                .setEmail(employee.getEmail())
                .setBirthday(employee.getBirthday())
                .setGender(employee.getGender());
    }

    public EmployeeResult toOrderDTO(Employee employee) {
        return new EmployeeResult()
                .setId(employee.getId())
                .setName(employee.getName())
                .setEmail(employee.getEmail())
                .setBirthday(employee.getBirthday())
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