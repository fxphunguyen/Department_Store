package com.phpn.repositories;

import com.phpn.repositories.model.LocationRegion;
import com.phpn.repositories.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order, Integer> {
}
