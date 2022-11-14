package com.phpn.repositories.model;

import lombok.*;
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

    @Column(name = "location_region_id", insertable = false, updatable = false)
    private Integer locationRegionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    public Order(Integer id) {
        this.id = id;
    }
}