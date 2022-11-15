package com.phpn.repositories.model;


import com.phpn.repositories.model.Item;
import com.phpn.repositories.model.Order;
import com.phpn.repositories.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Setter
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

    @Column(name = "item_id",  insertable = false, updatable = false)
    private Integer itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "order_id", insertable = false, updatable = false)
    private Integer orderId;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "discount", precision = 10, scale = 2)
    private BigDecimal discount;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "create_at")
    private Instant createAt;

    @Column(name = "update_at")
    private Instant updateAt;

    @Column(name = "grand_total", precision = 10, scale = 2)
    private BigDecimal grandTotal;

    @Column(name = "tax")
    private Float tax;

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