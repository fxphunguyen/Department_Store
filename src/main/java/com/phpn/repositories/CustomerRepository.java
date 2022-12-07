package com.phpn.repositories;


import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.ICustomer;
import com.phpn.repositories.model.ICustomerOrderHistory;
import com.phpn.repositories.model.ICustomerOwer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {

    @Query(value = "SELECT * FROM v_GetAllCustomerMixInfo" , nativeQuery = true)
    List<ICustomer> getAllCustomerMixInfo();

    @Query(value = "SELECT * FROM v_GetAllCustomerMixInfoByStatus" , nativeQuery = true)
    List<ICustomer>  getAllCustomerMixInfoByStatus();

    @Query(value = "call `ph-pn`.sp_findCustomerInfoByIdcustomer(:id);" , nativeQuery = true)
    ICustomer getCustomerInfoById(Integer id);

    @Query(value = "call `ph-pn`.sp_customerOwerById(:id);" , nativeQuery = true)
    List<ICustomerOwer> getCustomerOwerById(Integer id);

    @Query(value = " call sp_getCustomerHistoryOrderById(:id ,:startIntPaging,:endIntPaging);" , nativeQuery = true)
    List<ICustomerOrderHistory> getCustomerOrderHistory(Integer id, Integer startIntPaging, Integer endIntPaging);


    @Query(value = "call `ph-pn`.sp_getQuantityOrderByIdCustomer(:idCustomer);" , nativeQuery = true)
    Integer getQuantityOrderByCustomer(Integer idCustomer);



}


