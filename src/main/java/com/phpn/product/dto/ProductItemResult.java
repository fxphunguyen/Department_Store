package com.phpn.product.dto;

import com.phpn.brand.dto.BrandResult;
import com.phpn.category.dto.CategoryResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import vn.fx.qh.sapo.entities.product.ProductStatus;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductItemResult {
    private Integer id;
    private String image;
    private String title;
    private CategoryResult category;
    private BrandResult brand;
    private Integer available;
    private Integer trading;
    private ProductStatus status;
    private Instant createAt;
    private Instant updateAt;
}
