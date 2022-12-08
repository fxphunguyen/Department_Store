package com.phpn.order;

import com.phpn.order.sale.dto.OrderItemParam;
import com.phpn.order.sale.dto.OrderItemResult;
import com.phpn.product.item.ItemMapper;
import com.phpn.product.ProductMapper;
import vn.fx.qh.sapo.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.order.sale.SalesOrderItem;

@Component
public class SaleOrderItemMapper {
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ProductMapper productMapper;


    public OrderItemResult toDTO(SalesOrderItem orderItem) {
        return new OrderItemResult()
                .setId(orderItem.getId())
                .setOrderId(orderItem.getOrderId())
                .setProduct(productMapper.toDTO(orderItem.getProduct()))
                .setItem(itemMapper.toDTO(orderItem.getItem()))
                .setQuantity(orderItem.getQuantity())
                .setCreateAt(orderItem.getCreateAt());

    }

    public SalesOrderItem toModel(OrderItemParam orderItemParam) {
        return new SalesOrderItem()
                .setItemId(orderItemParam.getId())
                .setOrderId(orderItemParam.getOrderId())
                .setItemId(orderItemParam.getItemId())
                .setProductId(orderItemParam.getProductId())
                .setQuantity(orderItemParam.getQuantity())
                .setPrice(orderItemParam.getPrice())
                .setTax(orderItemParam.getTax());
    }
}
