package com.phpn.product.dto;


import com.phpn.brand.dto.BrandResult;
import com.phpn.category.dto.CategoryResult;
import com.phpn.media.MediaParam;
import com.phpn.media.MediaResult;
import com.phpn.product.item.ItemResult;
import com.phpn.tax.dto.TaxResult;
import com.phpn.tax.product_tax.ProductTaxResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import vn.fx.qh.sapo.entities.media.Media;
import vn.fx.qh.sapo.entities.product.Item;
import vn.fx.qh.sapo.entities.product.Product;
import vn.fx.qh.sapo.entities.product.ProductStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductDetailResult {

    private Integer id;
    private String title;
    private ProductStatus status;
    private Instant createAt;
    private Instant updateAt;
    private String description;
    private String unit;
    private String sku;
    private String barCode;
    private BigDecimal retailPrice;
    private BigDecimal importPrice;
    private BigDecimal wholesalePrice;
    private CategoryResult category;
    private BrandResult brand;
    private Boolean applyTax;
    private Boolean isTaxInclusive;
//    private List<ProductTaxResult> taxList;
    private List<MediaResult> mediaResults;
    private List<ItemResult> itemResults;
    private List<TaxResult> taxResults;
}
