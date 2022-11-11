package com.phpn.repositories;


import com.phpn.dto.customer.CustomerResult;
import com.phpn.repositories.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {
<<<<<<< HEAD
=======

    @Query("SELECT c " +
            "FROM Customer c " +
            "WHERE c.deleted = :deleted ")
    List<Customer> findAllCustomerResultByDeleted(boolean deleted);

    @Query("SELECT NEW com.phpn.dto.customer.CustomerResult ( " +
            "c.name, " +
            "c.phone, " +
            "c.deleted ) " +
            "FROM Customer c " +
            "WHERE c.deleted = :deleted ")
    List<CustomerResult> findCustomerByDeleted(boolean deleted);

>>>>>>> 9120c2af7e0c652f7a1143329c5de45d202f1f34

}
