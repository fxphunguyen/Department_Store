package com.phpn.services.suppliers;

import java.util.List;

import com.phpn.dto.suppliers.SupplierCreate;
import com.phpn.dto.suppliers.SupplierResult;
import com.phpn.repositories.model.Supplier;

public interface SupplierService {

    List<SupplierResult> findAll();

    SupplierResult findById(Integer id);

    Supplier save(SupplierCreate supplierCreate);

    void deleteById(Integer id);

}