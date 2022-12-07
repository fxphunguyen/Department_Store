package com.phpn.repositories.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Accessors(chain = true)
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "image", nullable = false, length = 50)
    private String image;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

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

    @Column(name = "retail_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal retailPrice;

    @Column(name = "import_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal importPrice;

    @Column(name = "wholesale_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal wholesalePrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @Column(name = "category_id", insertable = false, updatable = false)
    private Integer categoryId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
    @Column(name = "brand_id", insertable = false, updatable = false)
    private Integer brandId;

    @Column(name = "deleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean deleted = false;

    @Column(name = "apply_tax", nullable = false, columnDefinition = "boolean default false")
    private Boolean applyTax = false;

    @OneToMany
    private Set<Tax> taxs;

    public Product(Integer categoryId, Integer brandId) {
        setCategoryId(categoryId);
        setBrandId(brandId);
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product setCategoryId(Integer categoryId) {
        this.category = new Category(this.categoryId = categoryId);
        return this;
    }

    public Product setBrandId(Integer brandId) {
        this.brand = new Brand(this.brandId = brandId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}