package com.phpn.repositories;


import com.phpn.dto.customer.CustomerOrderResult;
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


    @Query(value = "SELECT * FROM v_GetAllCustomerMixInfoByStatus" , nativeQuery = true)
    List<ICustomer>  getAllCustomerMixInfoByStatus();

    @Query(value = "call `ph-pn`.sp_FindCustomerInfoById(:id);" , nativeQuery = true)
    ICustomer getCustomerInfoById(Integer id);

}


