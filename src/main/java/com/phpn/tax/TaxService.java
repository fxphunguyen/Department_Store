package com.phpn.tax;

import com.phpn.tax.dto.TaxParam;
import com.phpn.tax.dto.TaxResult;

import java.util.List;

public interface TaxService {

    List<TaxResult> findAll();
    TaxResult create(TaxParam taxParam);
}
