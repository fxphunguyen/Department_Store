package com.phpn.services.suppliers;

import java.util.List;
import com.phpn.dto.suppliers.SupplierResult;

public interface SupplierService {

    List<SupplierResult> findAll();

    SupplierResult findById(Integer id);

    void deleteById(Integer id);

}