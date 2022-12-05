package com.phpn.repositories;

import com.phpn.repositories.model.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PaymentOrderRepository extends JpaRepository<PaymentOrder, Integer> {

    List<PaymentOrder> findAllByOrderId(Integer orderId);

    List<PaymentOrder> findAllByOrderIdAndPaid(int orderId, BigDecimal paid);

}
