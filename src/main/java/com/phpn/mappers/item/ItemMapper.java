package com.phpn.mappers.item;

import com.phpn.dto.item.ItemParam;
import com.phpn.dto.item.ItemResult;
import com.phpn.mappers.product.ProductMapper;
import com.phpn.repositories.model.Item;
import com.phpn.repositories.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
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
                .setPrice(itemParam.getPrice());
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
                .setSku(item.getProduct().getSku())
                .setDiscount(item.getDiscount())
                .setAvailable(item.getAvailable());
    }
//    public  ItemResult toItemInfo(Item item){
//        return  new ItemResult()
//                .setId(item.getId())
//                .setQuantity(item.getQuantity())
//                .setAvailable(item.getAvailable());
////                .setProductResult(productMapper.toItemDTO(item.getProduct()));
//    }
}
