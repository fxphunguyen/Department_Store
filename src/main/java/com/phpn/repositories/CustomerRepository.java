package com.phpn.repositories;


import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.ICustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {


    @Query(
            "FROM Customer c " +
            "WHERE c.deleted = :deleted ")
    List<Customer> findAllCustomerResultByDeleted(boolean deleted);

    @Query(value = "SELECT * FROM v_GetAllCustomerMixInfo" , nativeQuery = true)
    List<ICustomer> getAllCustomerMixInfo();

}


