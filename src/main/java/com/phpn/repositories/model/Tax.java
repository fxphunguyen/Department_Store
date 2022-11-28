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
@Table(name = "taxs")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "code", length = 50)
    private String code;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "tax", nullable = false)
    private float tax;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tax)) return false;
        Tax tax = (Tax) o;
        return Objects.equals(getId(), tax.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
