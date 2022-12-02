package com.phpn.services.employee;

//import com.phpn.dto.employee.EmployeeParam;
import com.phpn.dto.employee.EmployeeResult;
import com.phpn.exceptions.NotFoundException;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.repositories.EmployeeRepository;
//import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.Employee;
//import com.phpn.repositories.model.EmployeePrinciple;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.phpn.mappers.employee.EmployeeMapper;
//import com.phpn.dto.employee.EmployeeResult;
//import com.phpn.repositories.model.Employee;
//import com.phpn.repositories.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResult> findAll() {
        return employeeRepository
        .findAll()
        .stream()
        .map(employeeMapper :: toDTO)
        .collect(Collectors.toList());
    }

    @Override
    public EmployeeResult findById(Integer id) {
        Optional<Employee> customerOptional = employeeRepository.findById(id);
        return employeeMapper.toDTO(customerOptional.get());
    }

//    @Override
//    public Employee getByEmail(String email) {
//        return null;
//    }
//
//    @Override
//    public EmployeeResult findByEmail(String email) {
//        Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);
//        if (!employeeOptional.isPresent()) throw new NotFoundException("Not found employee with email: " + email);
//        return employeeMapper.toDTO(employeeOptional.get());
//    }
//
//    @Override
//    public Optional<Employee> findEmployeeById(Integer id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Boolean existsByEmail(String email) {
//        return null;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);
//        if (!employeeOptional.isPresent()) throw new UsernameNotFoundException("Not found employee with email: " + email);
//        return EmployeePrinciple.build(employeeOptional.get());
//    }

}