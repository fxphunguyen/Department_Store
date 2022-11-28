package com.phpn.repositories.model;

import lombok.experimental.Accessors;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "suppliers")
@Accessors(chain = true)
public class Supplier {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "supplier_code", unique = true, nullable = false, length = 50)
    private String supplierCode;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private SupplierStatus status;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "employee_id", updatable = false, insertable = false)
    private Integer employeeId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "payment_method_id", updatable = false, insertable = false)
    private Integer paymentMethodId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_region_id", nullable = false)
    private LocationRegion locationRegion;

    @Column(name = "location_region_id", updatable = false, insertable = false)
    private Integer locationRegionId;

    @Column(name = "create_at", nullable = false)
    private String createAt;

    @Column(name = "update_at", nullable = false)
    private String updateAt;

    public Supplier(Integer id) {
        this.id = id;
    }

    public Supplier(Integer employeeId, Integer paymentMethodId, Integer locationRegionId) {
        setEmployeeId(employeeId);
        setPaymentMethodId(paymentMethodId);
        setLocationRegionId(locationRegionId);
    }

    public Supplier setEmployeeId(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }

    public Supplier setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethod = new PaymentMethod(this.paymentMethodId = paymentMethodId);
        return this;
    }

    public Supplier setLocationRegionId(Integer locationRegionId) {
        this.locationRegion = new LocationRegion(this.locationRegionId = locationRegionId);
        return this;
    }

}