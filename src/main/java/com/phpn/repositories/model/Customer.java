package com.phpn.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "customers")
public class Customer {

    public  Customer(Integer id){
        this.id = id;
    }

    public Customer(Integer employeeId , Integer locationRegionId){
        this.employee = new Employee(this.employeeId = employeeId);
        this.locationRegion = new LocationRegion(this.locationRegionId = locationRegionId);
    }


    public Customer setEmployeeId(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }

    public Customer setLocationRegionId(Integer locationRegionId) {
        this.locationRegion = new LocationRegion(this.locationRegionId = locationRegionId);
        return this;
    }
    public Customer setLocationRegionAll(Integer locationRegionId) {
        this.locationRegion = new LocationRegion(this.locationRegionId = locationRegionId);
        return this;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "customer_code", nullable = false, length = 50)
    private String customerCode;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "customer_group", nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerGroup customerGroup;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "birthday", nullable = false, length = 50)
    private String birthday;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerGender customerGender;

    @Column(name = "create_at", nullable = false, length = 50)
    private String createAt;

    @Column(name = "update_at", nullable = false, length = 50)
    private String updateAt;


    @Column(name = "location_region_id", insertable = false,updatable = false)
    private Integer locationRegionId ;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_region_id", nullable = false)
    private LocationRegion locationRegion;

    @Column(name = "employee_id", insertable = false,updatable = false)
    private Integer employeeId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;


}