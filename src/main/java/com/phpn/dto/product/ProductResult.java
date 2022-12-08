package com.phpn.dto.product;

import java.math.BigDecimal;

import com.phpn.dto.brand.BrandResult;
import com.phpn.dto.category.CategoryResult;
import com.phpn.dto.item.ItemResult;
import com.phpn.repositories.model.ProductStatus;
import com.phpn.repositories.model.Tax;
import com.phpn.repositories.model.TaxType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductResult {

    private Integer id;
    private String title;
    private String image;
    private ProductStatus status;
    private String createAt;
    private String updateAt;
    private String description;
    private String unit;
    private String sku;
    private String barCode;
    private Integer quantity;
    private BigDecimal retailPrice;
    private BigDecimal importPrice;
    private BigDecimal wholesalePrice;
    private Integer categoryId;
    private Integer brandId;
    private CategoryResult category;
    private BrandResult brand;
    private Tax tax;
    private ItemResult item;

}
