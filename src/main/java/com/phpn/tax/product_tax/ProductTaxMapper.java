package com.phpn.tax.product_tax;

import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.product.Product;
import vn.fx.qh.sapo.entities.product.tax.ProductTax;
import vn.fx.qh.sapo.entities.product.tax.ProductTaxId;

@Component
public class ProductTaxMapper {

    public ProductTaxResult toDTO(ProductTax productTax) {
        return new ProductTaxResult()
                .setId(productTax.getId())
                .setProductId(productTax.getProductId())
                .setTaxId(productTax.getTaxId())
                .setTaxType(productTax.getTaxType());
    }

    public ProductTax toModel(ProductTaxParam productTaxParam, Product product) {
        return new ProductTax()
                .setTaxId(productTaxParam.getTaxId())
                .setTaxType(productTaxParam.getTaxType())
                .setProductId(product.getId());
    }
}
