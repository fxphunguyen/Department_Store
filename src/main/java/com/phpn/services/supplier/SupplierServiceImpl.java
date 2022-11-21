package com.phpn.services.supplier;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.phpn.mappers.SupplierMapper;
import com.phpn.dto.supplier.SupplierResult;
import com.phpn.exceptions.NotFoundException;
import com.phpn.repositories.model.Supplier;
import com.phpn.repositories.SupplierRepository;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<SupplierResult> findAll() {
        System.out.println(supplierRepository
                .findAll()
                .stream()
                .map(supplier -> supplierMapper.toDTO(supplier))
                .collect(Collectors.toList())
        );
        return supplierRepository
        .findAll()
        .stream()
        .map(supplier -> supplierMapper.toDTO(supplier))
        .collect(Collectors.toList());

    }

    @Override
    public SupplierResult findById(Integer id) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (!supplierOptional.isPresent()) throw new NotFoundException("Not found supplier with id: " + id);
        return supplierMapper.toDTO(supplierOptional.get());
    }

}