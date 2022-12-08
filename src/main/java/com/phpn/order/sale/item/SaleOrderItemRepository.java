package com.phpn.order.sale.item;

import vn.fx.qh.sapo.entities.order.sale.*;
import vn.fx.qh.sapo.entities.product.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleOrderItemRepository extends JpaRepository<SaleOrderItem, Integer> {
    List<SaleOrderItem> findAllByOrderId(Integer id);

    Boolean existsByProduct(Product product);

    Optional<SaleOrderItem> findByProduct(Product product);

    Optional<SaleOrderItem> findByOrderAndProduct(SaleOrder order, Product product);

    int countSaleOrderItemByOrder(SaleOrder order);

    @Query("SELECT COUNT(oi) FROM SaleOrderItem  AS oi WHERE oi.id = :orderId")
    int countSaleOrderItemByOrderId(@Param("orderId") int orderId);


}
