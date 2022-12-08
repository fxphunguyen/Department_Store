package com.phpn.repositories;

import com.phpn.repositories.model.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PaymentOrderRepository extends JpaRepository<PaymentOrder, Integer> {


    @Query(value = "SELECT * FROM payment_order where order_id = :id" , nativeQuery = true)
    List<PaymentOrder> findAllByOrderId(Integer id);

    List<PaymentOrder> findAllByOrderIdAndPaid(int orderId, BigDecimal paid);

}
