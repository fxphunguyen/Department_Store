package com.phpn.repositories.model;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "suppliers")
public class Supplier {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "supplier_code", nullable = false, length = 50)
    private String supplierCode;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SupplierStatus status;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "employee_id", insertable = false, updatable = false)
    private Integer employeeId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_region_id", nullable = false)
    private LocationRegion locationRegion;

    @Column(name = "location_region_id", insertable = false, updatable = false)
    private Integer locationRegionId;

    @Column(name = "create_at", nullable = false)
    private Integer createAt;

    @Column(name = "update_at", nullable = false)
    private Integer updateAt;

    public Supplier(Integer id) {
        this.id = id;
    }

    public Supplier(Integer employeeId, Integer locationRegionId) {
        setEmployeeId(employeeId);
        setLocationRegionId(locationRegionId);
    }

    public Supplier setEmployeeId(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }

    public Supplier setLocationRegionId(Integer locationRegionId) {
        this.locationRegion = new LocationRegion(this.locationRegionId = locationRegionId);
        return this;
    }

}