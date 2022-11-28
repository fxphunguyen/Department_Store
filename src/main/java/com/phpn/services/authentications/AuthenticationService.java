package com.phpn.services.authentications;

import com.phpn.repositories.model.Employee;

public interface AuthenticationService {

    Employee findByEmailAndPassword(String email, String password);

}