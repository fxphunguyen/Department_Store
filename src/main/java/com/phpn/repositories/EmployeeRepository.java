package com.phpn.repositories;

import com.phpn.repositories.model.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e")
    List<Employee> findAll();

    Optional<Employee> findEmployeeById(Integer id);

}