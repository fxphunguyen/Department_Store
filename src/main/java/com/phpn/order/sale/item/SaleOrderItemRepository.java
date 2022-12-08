package com.phpn.order;

import vn.fx.qh.sapo.entities.order.sale.*;
import vn.fx.qh.sapo.entities.product.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleOrderItemRepository extends JpaRepository<SalesOrderItem, Integer> {
    List<SalesOrderItem> findAllByOrderId(Integer id);

    Boolean existsByProduct(Product product);

    Optional<SalesOrderItem> findByProduct(Product product);

    Optional<SalesOrderItem> findByOrderAndProduct(SaleOrder order, Product product);

    int countSalesOrderItemByOrder(SaleOrder order);

    @Query("SELECT COUNT(oi) FROM SalesOrderItem  AS oi WHERE oi.id = :orderId")
    int countSalesOrderItemByOrderId(@Param("orderId") int orderId);


}
