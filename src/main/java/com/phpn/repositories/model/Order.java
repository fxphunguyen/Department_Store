package com.phpn.repositories.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order_code", nullable = false, length = 50)
    private String orderCode;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @Column(name = "create_at", nullable = false, length = 50)
    private String createAt;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private Integer customerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "employee_id", insertable = false, updatable = false)
    private Integer employeeId;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_status_id", nullable = false)
    private OrderStatus orderStatus;


    @Column(name = "order_status_id", insertable = false, updatable = false)
    private Integer orderStatusId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "tax", precision = 10, scale = 2)
    private BigDecimal tax;

    @Column(name = "payment_method_id", insertable = false, updatable = false)
    private Integer paymentMethodId;

    @Column(name = "grand_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal grandTotal;

    @Column(name = "discount", precision = 10, scale = 2)
    private BigDecimal discount;

    public Order(Integer id) {
        this.id = id;
    }

    public Order(Integer customerId, Integer employeeId, Integer orderStatusId, Integer paymentMethodId) {
        setCustomerId(customerId);
        setEmployeeId(employeeId);
        setOrderStatusId(orderStatusId);
        setPaymentMethodId(paymentMethodId);
    }

    public Order setCustomerId(Integer customerId) {
        this.customer = new Customer(this.customerId = customerId);
        return this;
    }

    public Order setOrderStatusId(Integer orderStatusId) {
        this.orderStatus = new OrderStatus(this.orderStatusId = orderStatusId);
        return this;
    }


    public Order setEmployeeId(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }
    public Order setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethod = new PaymentMethod(this.paymentMethodId = paymentMethodId);
        return this;
    }
}