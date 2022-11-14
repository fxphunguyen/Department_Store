package com.phpn.mappers.employee;


import com.phpn.dto.employee.EmployeeParam;
import com.phpn.dto.employee.EmployeeResult;
import com.phpn.repositories.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeResult toDTO(Employee employee) {
        return new EmployeeResult()
                .setId(employee.getId())
                .setName(employee.getName())
                .setEmail(employee.getEmail())
                .setBirthday(employee.getBirthday())
                .setLocationRegionId(employee.getLocationRegionId())
                .setGender(employee.getGender());
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
