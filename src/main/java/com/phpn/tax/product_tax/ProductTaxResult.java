package com.phpn.tax.product_tax;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import vn.fx.qh.sapo.entities.product.tax.ProductTaxId;
import vn.fx.qh.sapo.entities.product.tax.TaxType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Accessors(chain = true)
public class ProductTaxResult {
    private ProductTaxId id;
    private Integer productId;
    private Integer taxId;
    private TaxType taxType;
}
