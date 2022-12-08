package com.phpn.dto.product;

import com.phpn.dto.product_image.ProductImageParam;
import vn.fx.qh.sapo.entities.ProductStatus;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Accessors(chain = true)
public class ProductWithImageParam implements Serializable {

    private Integer id;
    private String title;
    private ProductStatus status;
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
    private Boolean applyTax;
    private List<ProductImageParam> productImageParams;
}
