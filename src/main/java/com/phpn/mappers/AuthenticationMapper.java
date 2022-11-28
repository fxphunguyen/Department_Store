package com.phpn.mappers;

import org.springframework.stereotype.Component;

import com.phpn.repositories.model.Employee;
import com.phpn.dto.authentications.AuthenticationRegister;

@Component
public class AuthenticationMapper {

    public Employee toModel(AuthenticationRegister authenticationRegister) {
        return new Employee()
        .setName(authenticationRegister.getName())
        .setPhone(authenticationRegister.getPhone())
        .setEmail(authenticationRegister.getEmail())
        .setPassword(authenticationRegister.getPassword())
        .setLocationRegionId(authenticationRegister.getLocationRegionId());
    }

}