package com.phpn.repositories.model;

<<<<<<< HEAD
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
>>>>>>> huy_dev
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "supplier_code", nullable = false, length = 50)
    private String supplierCode;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
<<<<<<< HEAD
    private Employee employee;
=======
    private Employer employee;

>>>>>>> huy_dev

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_region_id", nullable = false)
    private LocationRegion locationRegion;
<<<<<<< HEAD

    public Supplier(Integer id) {
        this.id = id;
    }
=======
>>>>>>> huy_dev
}