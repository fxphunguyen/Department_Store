package com.phpn.repositories.model;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "birthday", nullable = false, length = 50)
    private String birthday;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_region_id", nullable = false)
    private LocationRegion locationRegion;

    @Column(name = "location_region_id", insertable = false, updatable = false)
    private Integer locationRegionId;

    @Lob
    @Column(name = "gender")
    private String gender;

    public Employee(Integer id) {
       this.id = id;
    }

    public Employee setLocationRegionId(Integer locationRegionId) {
        this.locationRegion = new LocationRegion(this.locationRegionId = locationRegionId);
        return this;
    }

}