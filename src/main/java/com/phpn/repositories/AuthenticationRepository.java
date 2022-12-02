package com.phpn.repositories;

import com.phpn.repositories.model.Employee;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AuthenticationRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmailAndPassword(String email, String password);

}