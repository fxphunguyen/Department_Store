package com.phpn.repositories.model;

<<<<<<< HEAD
import lombok.*;
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
>>>>>>> huy_dev
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

<<<<<<< HEAD

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
=======
@Data
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> huy_dev
@Accessors(chain = true)
@Entity
@Table(name = "items")
public class Item {
<<<<<<< HEAD

    public Item(Integer productId, Integer orderId, Integer employeeId, Integer supplierId) {
        setProductId(productId);
        setOrderId(orderId);
        setEmployeeId(employeeId);
        setSupplierId(supplierId);
    }

=======
>>>>>>> huy_dev
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

<<<<<<< HEAD
    @Column(name = "product_id", nullable = false, insertable = false, updatable = false)
    private Integer productId;
=======
>>>>>>> huy_dev
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

<<<<<<< HEAD
    @Column(name = "supplier_id", nullable = false, insertable = false, updatable = false)
    private Integer supplierId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "order_id", nullable = false, insertable = false, updatable = false)
    private Integer orderId;
=======
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;


    @ManyToOne(fetch = FetchType.LAZY)
    private Supplier supplier;

>>>>>>> huy_dev
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

<<<<<<< HEAD
    @Column(name = "employee_id", nullable = false, insertable = false, updatable = false)
    private Integer employeeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
=======
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    private Employer employer;
>>>>>>> huy_dev

    @Column(name = "sold")
    private Integer sold;

    @Column(name = "available")
    private Integer available;

    @Column(name = "defective")
    private Integer defective;

<<<<<<< HEAD
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
=======

>>>>>>> huy_dev
}