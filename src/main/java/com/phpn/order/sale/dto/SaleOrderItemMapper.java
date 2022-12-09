package com.phpn.order.sale.dto;

import com.phpn.product.ProductMapper;
import com.phpn.product.item.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.order.sale.SaleOrderItem;

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
                .setProduct(productMapper.toDTOProductSale(orderItem.getProduct()))
                .setQuantity(orderItem.getQuantity())
                .setPrice(orderItem.getPrice())
                .setTax(orderItem.getTax())
                .setDiscount(orderItem.getDiscount());
    }

    public SaleOrderItem toModel(SaleOrderItemParam orderItemParam) {
        return new SaleOrderItem()
                .setProductId(orderItemParam.getProductId())
                .setQuantity(orderItemParam.getQuantity())
                .setPrice(orderItemParam.getPrice())
                .setTax(orderItemParam.getTax());
    }
}
