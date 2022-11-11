package com.phpn.repositories.model;

<<<<<<< HEAD
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
@Table(name = "bill_of_ladings")
public class BillOfLading {
=======
import javax.persistence.*;
import java.math.BigDecimal;

import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "bill_of_ladings")
public class BillOfLading {

>>>>>>> ngoc_dev
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "price_cod", nullable = false, precision = 10, scale = 2)
    private BigDecimal priceCod;

    @Column(name = "fees", nullable = false, precision = 10, scale = 2)
    private BigDecimal fees;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "delivery_unit_id", nullable = false)
    private DeliveryUnit deliveryUnit;

<<<<<<< HEAD
=======
    @Column(name = "delivery_unit_id", insertable = false, updatable = false)
    private Integer deliveryUnitId;

>>>>>>> ngoc_dev
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "delivery_status_id", nullable = false)
    private DeliveryStatus deliveryStatus;

<<<<<<< HEAD
=======
    @Column(name = "delivery_status_id", insertable = false, updatable = false)
    private Integer deliveryStatusId;

>>>>>>> ngoc_dev
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

<<<<<<< HEAD
=======
    @Column(name = "order_id", insertable = false, updatable = false)
    private Integer orderId;

    public BillOfLading(Integer deliveryUnitId, Integer deliveryStatusId, Integer orderId) {
        setDeliveryUnitId(deliveryUnitId);
        setDeliveryStatusId(deliveryStatusId);
        setOrderId(orderId);
    }

    public BillOfLading setDeliveryUnitId(Integer deliveryUnitId) {
        this.deliveryUnit = new DeliveryUnit(this.deliveryUnitId = deliveryUnitId);
        return this;
    }

    public BillOfLading setDeliveryStatusId(Integer deliveryStatusId) {
        this.deliveryStatus = new DeliveryStatus(this.deliveryStatusId = deliveryStatusId);
        return this;
    }

    public BillOfLading setOrderId(Integer orderId) {
        this.order = new Order(this.orderId = orderId);
        return this;
    }
>>>>>>> ngoc_dev

}