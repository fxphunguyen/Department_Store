package com.phpn.services.supplier;

import java.util.List;

public interface SupplierService<$> {

    List<$> findAll();

    $ findById(Integer id);
    $ create($ supplier);
    $ update($ supplier);
    $ deleteById(Integer id);

}