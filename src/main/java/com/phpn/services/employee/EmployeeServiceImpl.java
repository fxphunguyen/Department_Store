package com.phpn.services.employee;

import com.phpn.dto.employee.EmployeeResult;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.repositories.EmployeeRepository;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResult> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper :: toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResult findById(Integer id) {
        Optional<Employee> customerOptional = employeeRepository.findById(id);
        return employeeMapper.toDTO(customerOptional.get());
    }
}
