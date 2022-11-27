package com.phpn.repositories;

import com.phpn.repositories.model.Order;
import com.phpn.repositories.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {


}
