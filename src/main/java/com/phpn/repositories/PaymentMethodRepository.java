package com.phpn.repositories;

import com.phpn.repositories.model.PaymentMethod;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {}