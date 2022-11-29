package com.phpn.repositories.model;

import lombok.experimental.Accessors;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@Accessors(chain = true)
public class Employee {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", unique = true, length = 50, nullable = false)
    private String email;

    @Column(name = "phone", unique = true, length = 50, nullable = false)
    private String phone;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "birthday", length = 50, nullable = false)
    private String birthday;

    @Lob
    @Column(name = "gender", length = 50, nullable = false)
    private String gender;

    @Column(name = "location_region_id", insertable = false, updatable = false)
    private Integer locationRegionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_region_id", nullable = false)
    private LocationRegion locationRegion;

    public Employee(Integer id) {
       this.id = id;
    }

    public Employee setLocationRegionId(Integer locationRegionId) {
        this.locationRegion = new LocationRegion(this.locationRegionId = locationRegionId);
        return this;
    }

}