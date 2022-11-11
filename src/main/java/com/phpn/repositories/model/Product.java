package com.phpn.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "products")
public class Product {
<<<<<<< HEAD
=======

    public Product(Integer categoryId, Integer brandId) {
        setCategoryId(categoryId);
        setBrandId(brandId);
    }
>>>>>>> huy_dev
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "image", nullable = false, length = 50)
    private String image;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "create_at", nullable = false, length = 50)
    private String createAt;

    @Column(name = "update_at", nullable = false, length = 50)
    private String updateAt;

    @Column(name = "description", nullable = false, length = 50)
    private String description;

    @Column(name = "unit", nullable = false, length = 50)
    private String unit;

    @Column(name = "sku", nullable = false, length = 50)
    private String sku;

    @Column(name = "bar_code", nullable = false, length = 50)
    private String barCode;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "retail_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal retailPrice;

    @Column(name = "import_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal importPrice;

    @Column(name = "wholesale_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal wholesalePrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

<<<<<<< HEAD
=======
    @Column(name = "category_id", insertable = false, updatable = false)
    private Integer categoryId;

>>>>>>> huy_dev
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

<<<<<<< HEAD
    @Column(name = "deleted", nullable = false)
    private Boolean deleted;


    public Product(Integer id) {
        this.id = id;
    }
=======
    @Column(name = "brand_id",insertable = false, updatable = false)
    private Integer brandId;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

>>>>>>> huy_dev
}