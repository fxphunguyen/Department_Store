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
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private Integer customerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_status_id", nullable = false)
    private OrderStatus orderStatus;


    @Column(name = "order_status_id", insertable = false, updatable = false)
    private Integer orderStatusId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_region_id", nullable = false)
    private LocationRegion locationRegion;

    @Column(name = "location_region_id", insertable = false, updatable = false)
    private Integer locationRegionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;


    @Column(name = "payment_method_id", insertable = false, updatable = false)
    private Integer paymentMethod_id;

    public Order(Integer id) {
        this.id = id;
    }

    public Order(Integer customerId, Integer orderStatusId, Integer locationRegionId, Integer paymentMethod_id) {
        setCustomerId(customerId);
        setOrderStatusId(orderStatusId);
        setLocationRegionId(locationRegionId);
        setPaymentMethod_id(paymentMethod_id);
    }

    public Order setCustomerId(Integer customerId) {
        this.customer = new Customer(this.customerId = customerId);
        return this;
    }

    public Order setOrderStatusId(Integer orderStatusId) {
        this.orderStatus = new OrderStatus(this.orderStatusId = orderStatusId);
        return this;
    }

    public Order setLocationRegionId(Integer locationRegionId) {
        this.locationRegion = new LocationRegion(this.locationRegionId = locationRegionId);
        return this;
    }
}