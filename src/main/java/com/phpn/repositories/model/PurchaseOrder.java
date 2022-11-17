package com.phpn.repositories.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

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
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "employee_id", insertable = false, updatable = false)
    private Integer employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(name = "payment_method_id", insertable = false, updatable = false)
    private Integer paymentMethodId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PurchaseOrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_item_id")
    private PurchaseOrderItem purchaseOrderItem;

    @Column(name = "purchase_order_item_id", insertable = false, updatable = false)
    private Integer purchaseOrderItemId;

    @Column(name = "create_at", nullable = false, length = 50)
    private String createAt;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "pays")
    private PurchaseOrderPays pays;
    
    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "grand_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal grandTotal;

    @Column(name = "discount", precision = 10, scale = 2)
    private Float discount;

    public PurchaseOrder(Integer supplierId, Integer purchaseOrderItemId, Integer employeeId, Integer paymentMethodId) {
        setSupplierId(supplierId);
        setEmployeeId(employeeId);
        setPurchaseOrderItemId(purchaseOrderItemId);
        setPaymentMethodId(paymentMethodId);
    }

    public PurchaseOrder(Integer id) {
        this.id = id;
    }

    public PurchaseOrder setSupplierId(Integer supplierId) {
        this.supplier = new Supplier(this.supplierId = supplierId);
        return this;
    }

    public PurchaseOrder setPurchaseOrderItemId(Integer purchaseOrderItemId) {
        this.purchaseOrderItem = new PurchaseOrderItem(this.purchaseOrderItemId = purchaseOrderItemId);
        return this;
    }

    public PurchaseOrder setEmployeeId(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }

    public PurchaseOrder setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethod = new PaymentMethod(this.paymentMethodId = paymentMethodId);
        return this;
    }

}