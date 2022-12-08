package com.phpn.order.sale;
import vn.fx.qh.sapo.entities.order.sale.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SalesOrderRepository extends JpaRepository<SaleOrder, Integer> {

    @Query("FROM SalesOrder c "
            + "WHERE c.customerId = :id ")
    List<SaleOrder> findAllOrderByCustomerId(Integer id);
}

