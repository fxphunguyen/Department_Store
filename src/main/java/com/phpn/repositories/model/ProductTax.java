package com.phpn.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Accessors(chain = true)
@Table(name = "products_taxs")
public class ProductTax {
    @EmbeddedId
    private ProductTaxId id;
    @Column(name = "product_id", insertable = false, updatable = false)
    private Integer productId;
    @Column(name = "tax_id", insertable = false, updatable = false)
    private Integer taxId;
<<<<<<< HEAD

    @Enumerated(EnumType.STRING)
    @Column(name = "type_tax")
    private TypeTax typeTax;
=======
>>>>>>> edbaac6350babd0e8a883b0475745bb7e21da4a0

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductTax)) return false;
        ProductTax that = (ProductTax) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
