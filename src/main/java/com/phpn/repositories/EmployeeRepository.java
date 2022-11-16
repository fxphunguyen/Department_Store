package com.phpn.repositories;

import com.phpn.dto.employee.EmployeeRResult;
import com.phpn.repositories.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e " +
            "FROM Employee e ")
    List<Employee> findAll();

    @Query(" SELECT e " +
            "FROM Employee e ")
    List<EmployeeRResult> findAllBySelect();
}

