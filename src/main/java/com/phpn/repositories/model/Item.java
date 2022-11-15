package com.phpn.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "sku", length = 20)
    private String sku;

    @Column(name = "mrp")
    private Float mrp;

    @Column(name = "discount", nullable = false)
    private Float discount;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "create_at", length = 20)
    private String createAt;

    @Column(name = "update_at", length = 20)
    private String updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Integer productId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_Id")
    private Supplier supplier;

    @Column(name = "supplier_Id", insertable = false, updatable = false)
    private Integer supplierId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "order_id", insertable = false, updatable = false)
    private Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "employee_id", insertable = false, updatable = false)
    private Integer employeeId;

    @Column(name = "sold")
    private Integer sold;

    @Column(name = "available")
    private Integer available;

    @Column(name = "defective")
    private Integer defective;

    public Item (Integer productId, Integer supplierId, Integer orderId, Integer employeeId){
        setProductId(productId);
        setSupplierId(supplierId);
        setOrderId(orderId);
        setEmployeeId(employeeId);
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Item setProductId(Integer productId) {
        this.product = new Product(this.productId = productId);
        return this;
    }

    public Item setSupplierId(Integer supplierId) {
        this.supplier = new Supplier(this.supplierId = supplierId);
        return this;
    }

    public Item setOrderId(Integer orderId) {
        this.order = new Order(this.orderId = orderId);
        return this;
    }

    public Item setEmployeeId(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }

}