package com.phpn.repositories;

import com.phpn.dto.product.ProductParam;
import com.phpn.dto.product.ProductResult;
import com.phpn.repositories.model.Order;
import com.phpn.repositories.model.OrderItem;
import com.phpn.repositories.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findAllByOrderId(Integer id);

    Boolean existsByProduct(Product product);

    Optional<OrderItem> findByProduct(Product product);

    Optional<OrderItem> findByOrderAndProduct(Order order, Product product);

    int countOrderItemByOrder(Order order);

    @Query("SELECT COUNT(oi) FROM OrderItem  AS oi WHERE oi.id = :orderId")
    int countOrderItemByOrderId(@Param("orderId") int orderId);


}
