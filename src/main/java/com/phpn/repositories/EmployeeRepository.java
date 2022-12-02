package com.phpn.repositories;

import java.util.List;
import java.util.Optional;

import com.phpn.repositories.model.Employee;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAll();

    Employee getByEmail(String email);

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findEmployeeById(Integer id);

    Boolean existsByEmail(String email);

}