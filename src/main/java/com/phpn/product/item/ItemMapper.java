package com.phpn.product.item;

import com.phpn.employee.dto.EmployeeResult;
import com.phpn.product.dto.CreateProductParam;
import com.phpn.product.dto.ProductCreate;
import com.phpn.product.dto.ProductResult;
import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.product.*;

import java.math.BigDecimal;

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

    public Item toModel(CreateItemParam createItemParam) {
        return new Item()
                .setQuantity(createItemParam.getQuantity())
                .setEmployeeId(createItemParam.getEmployeeId())
                .setProductId(createItemParam.getProductId())
                .setPrice(createItemParam.getPrice())
                .setAvailable(createItemParam.getAvailable());
    }

    public CreateItemParam toDTO(CreateProductParam createProductParam, ProductResult productResult) {
        return new CreateItemParam()
                .setQuantity(createProductParam.getQuantity())
                .setProductId(productResult.getId())
                .setEmployeeId(1)
                .setPrice(createProductParam.getCostPrice())
                .setAvailable(createProductParam.getQuantity());
    }

    public ItemResult toDTO(Item item) {
        return new ItemResult()
                .setId(item.getId())
                .setProductId(item.getProductId())
                .setEmployeeId(item.getEmployeeId())
                .setSupplierId(item.getSupplierId())
                .setPurchaseOrderId(item.getPurchaseOrderId())
                .setQuantity(item.getQuantity())
                .setPrice(item.getPrice())
                .setAvailable(item.getAvailable())
                .setTrading(item.getTrading());

    }
//    public  ItemResult toItemInfo(Item item){
//        return  new ItemResult()
//                .setId(item.getId())
//                .setQuantity(item.getQuantity())
//                .setAvailable(item.getAvailable());
////                .setProductResult(productMapper.toItemDTO(item.getProduct()));
//    }
}
