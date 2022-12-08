package com.phpn.product.item;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemService {
    List<ItemResult> findAll();

    int getTotalInventoryQuantityByProductId();

    int getAvailableInventoryQuantityByProductId();
}
