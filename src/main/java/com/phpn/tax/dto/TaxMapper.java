package com.phpn.tax.dto;

import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.product.tax.Tax;

@Component
public class TaxMapper {
    public TaxResult toDTO(Tax tax) {
        return new TaxResult()
                .setId(tax.getId())
                .setTax(tax.getTax())
                .setTitle(tax.getTitle())
                .setCode(tax.getCode());
    }
}
