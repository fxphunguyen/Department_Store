package com.phpn.payment;

import vn.fx.qh.sapo.entities.payment.sale.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PaymentOrderRepository extends JpaRepository<PaymentSalesOrder, Integer> {


    @Query(value = "SELECT * FROM payment_order where order_id = :id", nativeQuery = true)
    List<PaymentSalesOrder> findAllByOrderId(Integer id);

    List<PaymentSalesOrder> findAllByOrderIdAndPaid(int orderId, BigDecimal paid);

}
