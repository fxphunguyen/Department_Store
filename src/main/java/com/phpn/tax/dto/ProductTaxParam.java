package com.phpn.tax.dto;

import lombok.Getter;
import lombok.Setter;
import vn.fx.qh.sapo.entities.product.tax.TaxType;

import java.io.Serializable;

@Setter
@Getter
public class ProductTaxParam implements Serializable {
    private Integer taxId;
    private TaxType taxType;
}
