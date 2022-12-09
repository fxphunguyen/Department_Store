package com.phpn.customer;


import com.phpn.customer.customerDebt.CustomerDebt;
import vn.fx.qh.sapo.entities.customer.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {


    @Query(value = "call `ph-pn`.sp_getCustomerDebtByCustomerId( :customerId);" , nativeQuery = true)
    List<CustomerDebt> findCustomerDebtsByCustomerId(Integer customerId);

}


