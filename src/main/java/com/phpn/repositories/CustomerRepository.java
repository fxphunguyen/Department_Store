package com.phpn.repositories;


import com.phpn.dto.customer.CustomerResult;
import com.phpn.repositories.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {

}
