package com.phpn.services.suppliers;

import java.util.List;

import com.phpn.repositories.model.Supplier;
import com.phpn.repositories.SupplierRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findById(Integer id) {
        return supplierRepository.findById(id).get();
    }

    @Override
    public Supplier create(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

}