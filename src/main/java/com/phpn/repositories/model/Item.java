package com.phpn.repositories.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "items")
public class Item {

    public Item(Integer productId, Integer orderId, Integer employeeId, Integer supplierId) {
        setProductId(productId);
        setOrderId(orderId);
        setEmployeeId(employeeId);
        setSupplierId(supplierId);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "sku", length = 20)
    private String sku;

    @Column(name = "mrp")
    private Float mrp;

    @Column(name = "discounts")
    private Float discount;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "create_at", length = 20)
    private String createAt;

    @Column(name = "update_at", length = 20)
    private String updateAt;

    @Column(name = "product_id", nullable = false, insertable = false, updatable = false)
    private Integer productId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "supplier_id", nullable = false, insertable = false, updatable = false)
    private Integer supplierId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "order_id", nullable = false, insertable = false, updatable = false)
    private Integer orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "employee_id", nullable = false, insertable = false, updatable = false)
    private Integer employeeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "sold")
    private Integer sold;

    @Column(name = "available")
    private Integer available;

    @Column(name = "defective")
    private Integer defective;

    public Item setProductId(Integer productId) {
        this.product = new Product(this.productId = productId);
        return this;
    }

    public Item setOrderId(Integer orderId) {
        this.order = new Order(this.orderId = orderId);
        return this;
    }

    public Item setEmployee(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }

    public Item setSupplierId(Integer supplierId) {
        this.supplier = new Supplier(this.supplierId = supplierId);
        return this;
    }
}