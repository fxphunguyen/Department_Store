package com.phpn.dto.product;

import com.phpn.dto.brand.BrandResult;
import com.phpn.dto.category.CategoryResult;
import com.phpn.repositories.model.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

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
    private Integer defective;
    private Integer trading;
    private ProductStatus status;
    private String createAt;
    private String updateAt;
}
