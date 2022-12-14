package com.phpn.product.dto;

import com.phpn.media.MediaParam;
import com.phpn.tax.product_tax.ProductTaxParam;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class CreateProductParam implements Serializable {
    private Integer id;
    private String title;
    private Boolean enableSell;
    private String description;
    private String unit;
    private String sku;
    private String barCode;
    private Integer quantity;
    private Float mass;
    private BigDecimal costPrice;
    private BigDecimal retailPrice;
    private BigDecimal importPrice;
    private BigDecimal wholesalePrice;
    private Integer categoryId;
    private Integer brandId;
    private Boolean applyTax;
    private Boolean isTaxInclusive;
    private List<ProductTaxParam> taxList;
    private List<MediaParam> mediaList;
}
