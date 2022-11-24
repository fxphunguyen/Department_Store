package com.phpn.repositories;

<<<<<<< HEAD
import com.phpn.repositories.model.Order;
import com.phpn.repositories.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
=======
import com.phpn.repositories.model.LocationRegion;
import com.phpn.repositories.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order, Integer> {
>>>>>>> huy_dev
}
