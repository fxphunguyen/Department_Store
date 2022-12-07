package com.phpn.repositories;
import com.phpn.repositories.model.Order;
import com.phpn.repositories.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("FROM Order c " +
                    "WHERE c.customerId = :id ")
    List<Order> findAllOrderByCustomerId(Integer id);
}

