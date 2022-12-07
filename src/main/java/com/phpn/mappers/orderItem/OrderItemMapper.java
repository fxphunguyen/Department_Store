package com.phpn.mappers.orderItem;

import com.phpn.dto.orderItem.OrderItemParam;
import com.phpn.dto.orderItem.OrderItemResult;
import com.phpn.mappers.item.ItemMapper;
import com.phpn.mappers.product.ProductMapper;
import com.phpn.repositories.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ProductMapper productMapper;


    public OrderItemResult toDTO(OrderItem orderItem) {
        return new OrderItemResult()
                .setId(orderItem.getId())
                .setOrderId(orderItem.getOrderId())
                .setProduct(productMapper.toDTO(orderItem.getProduct()))
                .setItem(itemMapper.toDTO(orderItem.getItem()))
                .setQuantity(orderItem.getQuantity())
                .setCreateAt(orderItem.getCreateAt());

    }

    public OrderItem toModel(OrderItemParam orderItemParam) {
        return new OrderItem()
                .setItemId(orderItemParam.getId())
                .setOrderId(orderItemParam.getOrderId())
                .setItemId(orderItemParam.getItemId())
                .setProductId(orderItemParam.getProductId())
                .setQuantity(orderItemParam.getQuantity())
                .setPrice(orderItemParam.getPrice())
                .setTax(orderItemParam.getTax());
    }
}
