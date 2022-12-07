package com.phpn.repositories.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "order_item")
@Accessors(chain = true)

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Integer productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "item_id", insertable = false, updatable = false)
    private Integer itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "order_id", insertable = false, updatable = false)
    private Integer orderId;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "create_at")
    private Instant createAt;

    @Column(name = "update_at")
    private Instant updateAt;

    @Column(name = "tax", nullable = false)
    private Float tax;

    @Column(name = "discount", precision = 10, scale = 2)
    private BigDecimal discount;


    public OrderItem(Integer productId, Integer itemId, Integer orderId) {
        setProductId(productId);
        setItemId(itemId);
        setOrderId(orderId);
    }

    public OrderItem setProductId(Integer productId) {
        this.product = new Product(this.productId = productId);
        return this;
    }

    public OrderItem setItemId(Integer itemId) {
        this.item = new Item(this.itemId = itemId);
        return this;
    }

    public OrderItem setOrderId(Integer orderId) {
        this.order = new Order(this.orderId = orderId);
        return this;
    }
}