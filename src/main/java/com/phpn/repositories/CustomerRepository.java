package com.phpn.repositories;


import com.phpn.repositories.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {


//@Query("SELECT NEW com.phpn.dto.customer.CustomerResult(" +
//        "c.id , " +
//        "c.customerCode , " +
//        "c.name , " +
//        "c.phone, " +
//        "c.customerGroup , " +
//        "c.email , " +
//        "c.birthday , " +
//        "c.status , " +
//        "c.createAt, " +
//        "c.updateAt, " +
//        "l.address, " +
//        "l.wardName, " +
//        "l.districtName, " +
//        "l.provinceName ) " +
//        " FROM Customer as c , LocationRegion as l  WHERE c.locationRegionId = l.id  AND c.deleted= false ")
//List<CustomerResult> findAllCustomer();

    @Query(
            "FROM Customer c " +
            "WHERE c.deleted = :deleted ")
    List<Customer> findAllCustomerResultByDeleted(boolean deleted);

    @Query("SELECT NEW com.phpn.dto.customer.CustomerOrderResult ( " +
            "c.name, " +
            "c.phone, " +
            "c.customerCode, " +
            "c.locationRegionId, " +
            "c.employeeId) " +
            "FROM Customer c " +
            "WHERE c.id = :id")
    Optional<Customer> findCustomerById(Integer id);

}


