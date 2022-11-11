package com.phpn.services.suppliers;

import java.util.List;
import com.phpn.repositories.model.Supplier;

public interface SupplierService {

    List<Supplier> findAll();

    Supplier findById(Integer id);
    Supplier create(Supplier supplier);

}