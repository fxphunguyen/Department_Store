package com.phpn.order.sale.dto;

import com.phpn.product.item.ItemMapper;
import com.phpn.product.ProductMapper;
import vn.fx.qh.sapo.entities.order.sale.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaleOrderItemMapper {
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ProductMapper productMapper;


    public SaleOrderItemResult toDTO(SaleOrderItem orderItem) {
        return new SaleOrderItemResult()
                .setId(orderItem.getId())
                .setOrderId(orderItem.getOrderId())
//                productMapper.toDTO(orderItem.getProduct())
             //   .setProduct(productMapper.toModel(orderItem.getProduct()))
//                .setItem(itemMapper.toDTO(orderItem.getItem()))
                .setQuantity(orderItem.getQuantity());

    }

    public SaleOrderItem toModel(SaleOrderItemParam orderItemParam) {
        return new SaleOrderItem()
                .setProductId(orderItemParam.getProductId())
                .setQuantity(orderItemParam.getQuantity())
                .setPrice(orderItemParam.getPrice())
                .setTax(orderItemParam.getTax());
    }
}
