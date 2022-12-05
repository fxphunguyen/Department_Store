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
<<<<<<< HEAD
=======

    @Query("FROM Order c " +
                    "WHERE c.customerId = :id ")
    List<Order> findAllOrderByCustomerId(Integer id);


>>>>>>> main
>>>>>>> de566f8afd7f279511a167d3120b288b8a1b604b
}

