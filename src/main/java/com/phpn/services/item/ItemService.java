package com.phpn.services.item;

import com.phpn.dto.item.ItemResult;
import com.phpn.dto.product.ProductResult;
import com.phpn.repositories.model.Item;
import com.phpn.repositories.model.Product;

import java.util.List;

public interface ItemService {
    List<ItemResult> findAll();


//    List<ItemResult> findAllByProductIdAndAvailableAndQuantity();

}
