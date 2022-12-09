package com.phpn.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fx.qh.sapo.entities.employee.Employee;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAll();

    Employee getByEmail(String email);

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findEmployeeById(Integer id);

    Boolean existsByEmail(String email);

}