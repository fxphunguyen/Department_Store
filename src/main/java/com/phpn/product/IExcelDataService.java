package com.phpn.product;

import vn.fx.qh.sapo.entities.product.Product;

import java.util.List;

public interface IExcelDataService {
    List<Product> getExcelDataAsList();

    int saveExcelData(List<Product> products);
}
