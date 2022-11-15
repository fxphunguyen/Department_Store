package com.phpn.repositories.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "purchase_order")
public class PurchaseOrder {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "purchase_order_code", length = 45)
    private String purchaseOrderCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "supplier_id", insertable = false, updatable = false)
    private Integer supplierId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Integer productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "employee_id", insertable = false, updatable = false)
    private Integer employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(name = "payment_method_id", insertable = false, updatable = false)
    private Integer paymentMethodId;

    @Size(max = 45)
    @Column(name = "status", length = 45)
    private String status;

    public PurchaseOrder(Integer supplierId, Integer productId, Integer employeeId, Integer paymentMethodId) {
        setSupplierId(supplierId);
        setEmployeeId(employeeId);
        setProductId(productId);
        setPaymentMethodId(paymentMethodId);
    }

    public PurchaseOrder setSupplierId(Integer supplierId) {
        this.supplier = new Supplier(this.supplierId = supplierId);
        return this;
    }

    public PurchaseOrder setEmployeeId(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }

    public PurchaseOrder setProductId(Integer productId) {
        this.product = new Product(this.productId = productId);
        return this;
    }

    public PurchaseOrder setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethod = new PaymentMethod(this.paymentMethodId = paymentMethodId);
        return this;
    }

}