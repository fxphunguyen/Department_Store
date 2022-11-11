package com.phpn.repositories;

import com.phpn.repositories.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findAllByProductIdOrderByCreateAt(Integer productId);
}
