package com.phpn.product.item;

import java.util.List;

public interface ItemService {
    List<ItemResult> findAll();

    int getTotalInventoryQuantityByProductId(Integer productId);

    int getAvailableInventoryQuantityByProductId(Integer productId);
}
