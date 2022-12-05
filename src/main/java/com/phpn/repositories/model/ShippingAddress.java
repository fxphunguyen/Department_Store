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
@Accessors(chain = true)
@Table(name = "shipping_address")
public class ShippingAddress {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(name = "mobile", length = 50)
    private String mobile;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "line1", nullable = false, length = 50)
    private String line1;
    @Column(name = "line2", length = 50)
    private String line2;

    @Column(name = "district_id", nullable = false)
    private Integer districtId;

    @Column(name = "district_name", nullable = false, length = 50)
    private String districtName;

    @Column(name = "province_id", nullable = false)
    private Integer provinceId;

    @Column(name = "province_name", nullable = false, length = 50)
    private String provinceName;

    @Column(name = "ward_id", nullable = false)
    private Integer wardId;

    @Column(name = "ward_name", nullable = false, length = 50)
    private String wardName;

    @Column(name = "zip_code", length = 10)
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private Integer customerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "supplier_id", insertable = false, updatable = false)
    private Integer supplierId;

    @Column(name = "default",  insertable = true)
    private Boolean isDefault;

    public ShippingAddress setCustomerId(Integer customerId) {
        this.customer = new Customer(this.customerId = customerId);
        return this;
    }

    public ShippingAddress setDefault(Boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    public boolean isDefault() {
        return isDefault;
    }
}
