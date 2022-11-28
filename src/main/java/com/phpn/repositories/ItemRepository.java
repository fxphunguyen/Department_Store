package com.phpn.repositories;

import com.phpn.repositories.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findAllByProductIdOrderByCreateAt(Integer productId);

    List<Item> findAllByProductIdAndAvailableGreaterThanOrderByCreateAt(int productId, int available);
}
