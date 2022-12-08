package com.phpn.product.dto;

import com.phpn.brand.dto.BrandResult;
import com.phpn.category.dto.CategoryResult;
import com.phpn.product.item.ItemResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import vn.fx.qh.sapo.entities.product.ProductStatus;
import vn.fx.qh.sapo.entities.product.tax.Tax;

import java.math.BigDecimal;

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
