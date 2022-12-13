package com.phpn.product.item;

import com.phpn.product.dto.CreateProductParam;
import com.phpn.product.dto.ProductResult;
import vn.fx.qh.sapo.entities.product.Item;

import java.util.List;

public interface ItemService {
    List<ItemResult> findAll();

    int getTotalInventoryQuantityByProductId(Integer productId);

    int getAvailableInventoryQuantityByProductId(Integer productId);

    ItemResult create(CreateItemParam CreateItemParam);

    List<ItemResult> findAllByProductId(Integer productId);

}
