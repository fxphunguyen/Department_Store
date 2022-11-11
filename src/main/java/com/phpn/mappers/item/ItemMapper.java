package com.phpn.mappers.item;

import com.phpn.dto.item.ItemParam;
import com.phpn.dto.item.ItemResult;
import com.phpn.repositories.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item toModel(ItemParam itemParam) {
        return new Item()
                .setId(itemParam.getId())
                .setProductId(itemParam.getProductId())
                .setSupplierId(itemParam.getSupplierId())
                .setEmployeeId(itemParam.getEmployeeId())
                .setOrderId(itemParam.getOrderId())
                .setQuantity(itemParam.getQuantity())
                .setSku(itemParam.getSku())
                .setPrice(itemParam.getPrice())
                .setDiscount(itemParam.getDiscount());
    }

    public ItemResult toDTO(Item item) {
        return new ItemResult()
                .setId(item.getId())
                .setEmployeeId(item.getEmployeeId())
                .setOrderId(item.getOrderId())
                .setProductId(item.getProductId())
                .setSupplierId(item.getSupplierId())
                .setQuantity(item.getQuantity())
                .setPrice(item.getPrice())
                .setSku(item.getSku())
                .setDiscount(item.getDiscount());
    }
}
