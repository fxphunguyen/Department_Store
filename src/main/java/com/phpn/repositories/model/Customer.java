package com.phpn.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
@Accessors(chain = true)
public class Customer {

    public  Customer(Integer id){
        this.id = id;
    }

    public Customer(Integer employeeId , Integer locationRegionId){
       setEmployeeId(employeeId);
       setLocationRegionId(locationRegionId);
    }


    public Customer setEmployeeId(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }

    public Customer setLocationRegionId(Integer locationRegionId) {
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
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

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