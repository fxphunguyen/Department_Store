package com.phpn.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
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

    @Column(name = "grand_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal grandTotal;

    @Column(name = "sub_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal subTotal;

    @Column(name = "discount", precision = 10, scale = 2)
    private BigDecimal discount;

    public Order(Integer id) {
        this.id = id;
    }

    public Order(Integer customerId, Integer employeeId, Integer orderStatusId) {
        setCustomerId(customerId);
        setEmployeeId(employeeId);
        setOrderStatusId(orderStatusId);
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
}