package com.phpn.repositories.model;

import javax.persistence.*;
import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
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

    @Column(name = "employee_id", insertable = false, updatable = false)
    private Integer employeeId;

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
    @JoinColumn(name = "delivery_id", nullable = false)
    private DeliveryUnit delivery;

    @Column(name = "delivery_id", insertable = false, updatable = false)
    private Integer deliveryId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(name = "payment_id", insertable = false, updatable = false)
    private Integer paymentId;

    public Order(Integer customerId, Integer employeeId, Integer orderStatusId, Integer locationRegionId, Integer deliveryId, Integer paymentId) {
        setCustomerId(customerId);
        setEmployeeId(employeeId);
        setOrderStatusId(orderStatusId);
        setDeliveryId(deliveryId);
        setLocationRegionId(locationRegionId);
        setPaymentId(paymentId);
    }

    public Order(Integer integer) {
    }

    public Order setCustomerId(Integer customerId) {
        this.customer = new Customer(this.customerId = customerId);
        return this;
    }

    public Order setEmployeeId(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }

    public Order setOrderStatusId(Integer orderStatusId) {
        this.orderStatus = new OrderStatus(this.orderStatusId = orderStatusId);
        return this;
    }

    public Order setDeliveryId(Integer deliveryId) {
        this.delivery = new DeliveryUnit(this.deliveryId = deliveryId);
        return this;
    }

    public Order setLocationRegionId(Integer locationRegionId) {
        this.locationRegion = new LocationRegion(this.locationRegionId = locationRegionId);
        return this;
    }

    public Order setPaymentId(Integer paymentId) {
        this.payment = new Payment(this.paymentId = paymentId);
        return this;
    }

}