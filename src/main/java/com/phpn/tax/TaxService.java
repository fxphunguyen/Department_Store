package com.phpn.tax;

import com.phpn.tax.dto.TaxParam;
import com.phpn.tax.dto.TaxResult;
import vn.fx.qh.sapo.entities.product.tax.Tax;

import java.util.List;

public interface TaxService {

    List<TaxResult> findAllTax();
    TaxResult create(TaxParam taxParam);
}
