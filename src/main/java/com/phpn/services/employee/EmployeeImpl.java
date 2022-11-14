package com.phpn.services.employee;

import com.phpn.dto.employee.EmployeeResult;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.repositories.EmployeeRepository;
import com.phpn.repositories.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResult> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper :: toDTO)
                .collect(Collectors.toList());
    }
}
