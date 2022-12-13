package com.phpn.tax;

import com.phpn.tax.dto.TaxParam;
import com.phpn.tax.dto.TaxResult;
import com.phpn.tax.product_tax.ProductTaxResult;
import vn.fx.qh.sapo.entities.product.tax.ProductTax;
import vn.fx.qh.sapo.entities.product.tax.Tax;

import java.util.List;

public interface TaxService {

    List<TaxResult> findAllTax();

    Tax findById(Integer id);

    TaxResult create(TaxParam taxParam);

    List<TaxResult> findAllByProductId(List<ProductTaxResult> productTaxResults);
}
