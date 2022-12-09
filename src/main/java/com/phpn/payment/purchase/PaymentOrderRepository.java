package com.phpn.payment.purchase;

import vn.fx.qh.sapo.entities.payment.sale.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PaymentOrderRepository extends JpaRepository<PaymentSaleOrder, Integer> {


    @Query(value = "SELECT * FROM payment_order where order_id = :id", nativeQuery = true)
    List<PaymentSaleOrder> findAllByOrderId(Integer id);

    List<PaymentSaleOrder> findAllByOrderIdAndPaid(int orderId, BigDecimal paid);


    @Query(value = "call sp_getPaidTotalByCustomerById(:id);" , nativeQuery = true)
    BigDecimal getPaidTotalByCustomerById(Integer id);

    @Query(value = "call sp_getDebtTotalCustomerById(:id);" , nativeQuery = true)
    BigDecimal getDebtTotalByCustomerById(Integer id);
}
