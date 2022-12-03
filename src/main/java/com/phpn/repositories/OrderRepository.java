package com.phpn.repositories;

import com.phpn.repositories.model.Order;
<<<<<<< HEAD

=======
>>>>>>> main
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
<<<<<<< HEAD
=======

    @Query("FROM Order c " +
                    "WHERE c.customerId = :id ")
    List<Order> findAllOrderByCustomerId(Integer id);


>>>>>>> main
}

