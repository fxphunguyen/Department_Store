package com.phpn.mappers.employee;


import com.phpn.dto.employee.EmployeeParam;
import com.phpn.dto.employee.EmployeeRResult;
import com.phpn.dto.employee.EmployeeResult;
import com.phpn.repositories.model.Employee;
import com.phpn.repositories.model.Supplier;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public  Employee toDTO(Supplier supplier) {
        return new Employee()
                .setId(supplier.getEmployee().getId())
                .setName(supplier.getEmployee().getName());
    }

    public EmployeeResult toDTO(Employee employee) {
        return new EmployeeResult()
                .setId(employee.getId())
                .setName(employee.getName())
                .setEmail(employee.getEmail())
                .setBirthday(employee.getBirthday())
                .setLocationRegionId(employee.getLocationRegionId())
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
