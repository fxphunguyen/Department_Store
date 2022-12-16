package com.phpn.product;

import org.springframework.stereotype.Service;
import vn.fx.qh.sapo.entities.product.Product;

import java.util.List;

@Service
public class ExcelDataServiceImpl implements IExcelDataService{
    @Override
    public List<Product> getExcelDataAsList() {
        return null;
    }

    @Override
    public int saveExcelData(List<Product> products) {
        return 0;
    }
}
