package com.phpn.repositories;
<<<<<<< HEAD

=======
>>>>>>> origin/dev_c5
import com.phpn.repositories.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}

