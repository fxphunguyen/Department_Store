package com.phpn.services.supplier;

import java.util.List;
import com.phpn.repositories.model.Supplier;

public interface SupplierService {

    List<Supplier> findAll();

    Supplier findById(Integer id);

}