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
@Query("SELECT NEW com.phpn.dto.customer.CustomerResult(" +
        "c.id , " +
        "c.customerCode , " +
        "c.name , " +
        "c.phone, " +
        "c.customerGroup , " +
        "c.email , " +
        "c.birthday , " +
        "c.status , " +
        "c.createAt, " +
        "c.updateAt, " +
        "l.address, " +
        "l.wardName, " +
        "l.districtName, " +
        "l.provinceName ) " +
        " FROM Customer as c , LocationRegion as l  WHERE c.locationRegionId = l.id  AND c.deleted= false ")
List<CustomerResult> findAllCustomer();
>>>>>>> huy_dev

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


}
