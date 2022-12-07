package com.phpn.services.suppliers;

import com.phpn.dto.suppliers.SupplierCreate;
import com.phpn.dto.suppliers.SupplierResult;
import com.phpn.exceptions.NotFoundException;
import com.phpn.mappers.SupplierMapper;
import com.phpn.repositories.SupplierRepository;
import com.phpn.repositories.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;



    @Autowired
    private SupplierRepository supplierRepository;


    @Override
    @Transactional(readOnly = true)
    public List<SupplierResult> findAll() {
        List<SupplierResult> supplierResultList = supplierRepository
        .findAll()
        .stream()
        .map(supplier -> supplierMapper.toDTO(supplier))
        .collect(Collectors.toList());

        if (supplierResultList.isEmpty()) throw new NotFoundException("Not found supplier data or is empty!");
        return supplierResultList;
    }

    @Override
    @Transactional(readOnly = true)
    public SupplierResult findById(Integer id) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (!supplierOptional.isPresent()) throw new NotFoundException("Not found supplier with id: " + id);
        return supplierMapper.toDTO(supplierOptional.get());
    }

    @Override
    public Supplier save(SupplierCreate supplierCreate) {
        return supplierRepository.save(supplierMapper.toModel(supplierCreate));
    }

    @Override
    public void deleteById(Integer id) {
        findById(id);
        supplierRepository.deleteById(id);
    }

}