package com.phpn.product.item;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.fx.qh.sapo.entities.product.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findAllByProductIdOrderByCreateAt(Integer productId);

    List<Item> findAllByProductIdAndAvailableGreaterThanOrderByCreateAt(Integer productId, Integer available);


    @Query(value = "call sp_getTotalInventoryQuantityByProductId(:productId)", nativeQuery = true)
    Optional<Integer> getTotalInventoryQuantityByProductId(@Param("productId") Integer productId);

    @Query(value = "call sp_getAvailableInventoryQuantityByProductId(:productId)", nativeQuery = true)
    Optional<Integer> getAvailableInventoryQuantityByProductId(@Param("productId") Integer productId);
}
