package com.phpn.product.dto;

import com.phpn.brand.dto.BrandResult;
import com.phpn.category.dto.CategoryResult;
import com.phpn.tax.dto.TaxResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import vn.fx.qh.sapo.entities.product.ProductStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

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
    private Instant createdAt;
    private Instant updatedAt;
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
    private List<TaxResult> taxSaleList;
    private List<TaxResult> taxPurchaseList;
    private Boolean applyTax;
    private int totalInventory;
    private int availableInventory;


}
