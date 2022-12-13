package com.phpn.tax.product_tax;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.fx.qh.sapo.entities.product.Product;
import vn.fx.qh.sapo.entities.product.tax.ProductTax;

import java.util.List;

public interface ProductTaxService  {
    List<ProductTaxResult> create(List<ProductTaxParam> productTaxParams, Product product);

    List<ProductTaxResult> findAllByProductId(Integer productId);
}
