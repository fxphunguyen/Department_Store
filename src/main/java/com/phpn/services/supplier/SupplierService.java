package com.phpn.services.supplier;

import java.util.List;
import com.phpn.dto.supplier.SupplierResult;

public interface SupplierService {

    List<SupplierResult> findAll();

    SupplierResult findById(Integer id);

}