package com.phpn.repositories;

import com.phpn.repositories.model.PaymentPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentPurchase, Integer> {


}
