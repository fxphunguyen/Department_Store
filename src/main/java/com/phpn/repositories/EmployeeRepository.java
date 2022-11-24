package com.phpn.repositories;

import com.phpn.dto.employee.EmployeeRResult;
import com.phpn.repositories.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e " +
            "FROM Employee e ")
    List<Employee> findAll();

    Optional<Employee> findEmployeeById(Integer id);

}

