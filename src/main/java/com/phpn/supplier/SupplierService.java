package com.phpn.supplier;

import java.util.List;

import vn.fx.qh.sapo.entities.product.supplier.*;
import com.phpn.supplier.SupplierCreate;
import com.phpn.supplier.SupplierResult;

public interface SupplierService {

    List<SupplierResult> findAll();

    SupplierResult findById(Integer id);

    Supplier save(SupplierCreate supplierCreate);

    void deleteById(Integer id);

}