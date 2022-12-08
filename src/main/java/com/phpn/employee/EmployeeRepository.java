package com.phpn.repositories.employee;

import java.util.List;
import java.util.Optional;

import vn.fx.qh.sapo.entities.employee.*;

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