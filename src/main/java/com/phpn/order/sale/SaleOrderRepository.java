package com.phpn.order.sale;
import com.phpn.customer.dto.HistoryCustomerOrder;
import com.phpn.order.sale.dto.SaleOrderByCustomer;
import com.phpn.order.sale.dto.SaleOrderResult;
import vn.fx.qh.sapo.entities.order.sale.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;


@Repository
public interface SaleOrderRepository extends JpaRepository<SaleOrder, Integer> {
    List<SaleOrder> findAllSaleOrderByCustomerId(Integer customerId);



    @Query(value = "call `ph-pn`.sp_getSpendTotalByCustomerId(:id);" , nativeQuery = true)
    BigDecimal getSpendTotalByCustomerId(Integer id);

    @Query(value = "call sp_getCountOrderByCustomerId(:id);" , nativeQuery = true)
    Integer getQuantityProductOrderById(Integer id);


    @Query("FROM SaleOrder WHERE customerId = :id")
    List<SaleOrder> findAllCustomerOrderHistory(Integer id);

    @Query(value = "call sp_getLastDayOrderByCustomerId( :customerId);" , nativeQuery = true)
    Instant getLastDayOrderByCustomerId(Integer customerId);
}

