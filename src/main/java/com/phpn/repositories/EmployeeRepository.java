package com.phpn.repositories;

import java.util.List;
import com.phpn.repositories.model.Employee;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e")
    List<Employee> findAll();

}