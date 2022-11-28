package com.phpn.services.item;

import com.phpn.dto.item.ItemRResult;
import com.phpn.dto.item.ItemResult;
import com.phpn.repositories.model.Item;

import java.util.List;

public interface ItemService {
    List<ItemRResult> findAll();


}
