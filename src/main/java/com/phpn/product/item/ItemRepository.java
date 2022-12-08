package com.phpn.product.item;

import vn.fx.qh.sapo.entities.product.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findAllByProductIdOrderByCreateAt(Integer productId);

    List<Item> findAllByProductIdAndAvailableGreaterThanOrderByCreateAt(Integer productId, Integer available);


//    int store();
}
