package com.phpn.services.suppliers;

import java.util.List;

import vn.fx.qh.sapo.entities.Supplier;
import com.phpn.dto.suppliers.SupplierCreate;
import com.phpn.dto.suppliers.SupplierResult;

public interface SupplierService {

    List<SupplierResult> findAll();

    SupplierResult findById(Integer id);

    Supplier save(SupplierCreate supplierCreate);

    void deleteById(Integer id);

}