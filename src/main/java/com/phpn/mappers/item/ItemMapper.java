package com.phpn.mappers.item;

import com.phpn.dto.item.ItemParam;
import com.phpn.dto.item.ItemRResult;
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
                .setPurchaseOrderId(itemParam.getPurchaseOrderId())
                .setQuantity(itemParam.getQuantity())
                .setSku(itemParam.getSku())
                .setPrice(itemParam.getPrice())
                .setDiscount(itemParam.getDiscount());
    }

    public ItemResult toDTO(Item item) {
        return new ItemResult()
                .setId(item.getId())
                .setEmployeeId(item.getEmployeeId())
                .setPurchaseOrderId(item.getPurchaseOrderId())
                .setProductId(item.getProductId())
                .setSupplierId(item.getSupplierId())
                .setQuantity(item.getQuantity())
                .setPrice(item.getPrice())
                .setSku(item.getSku())
                .setDiscount(item.getDiscount());
    }
    public ItemRResult toRDTO(Item item) {
        return (ItemRResult) new ItemRResult()
                .setId(item.getId())
                .setQuantity(item.getQuantity())
                .setPrice(item.getPrice())
                .setDiscount(item.getDiscount());
    }
}
