package com.phpn.services.authentications;

import com.phpn.exceptions.NotFoundException;
import com.phpn.repositories.model.Employee;
import com.phpn.repositories.AuthenticationRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Override
    public Employee findByEmailAndPassword(String email, String password) {
        Employee employee = authenticationRepository.findByEmailAndPassword(email, password);
        if (employee.getEmail() == null || employee.getEmail().isEmpty()) throw new NotFoundException("Not found employee data or is empty!");
        return employee;
    }

}