package com.phpn.product.item;

import com.phpn.product.item.ItemParam;
import com.phpn.product.item.ItemResult;
import vn.fx.qh.sapo.entities.Item;
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
                .setQuantity(itemParam.getQuantity());
    }

    public ItemResult toDTO(Item item) {
        return new ItemResult()
                .setId(item.getId())
                .setEmployeeId(item.getEmployeeId())
                .setPurchaseOrderId(item.getPurchaseOrderId())
                .setProductId(item.getProductId())
                .setSupplierId(item.getSupplierId())
                .setQuantity(item.getQuantity())
                .setSku(item.getProduct().getSku())
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
