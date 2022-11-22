package com.phpn.services.suppliers;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.phpn.repositories.model.Supplier;
import com.phpn.repositories.SupplierRepository;
import com.phpn.mappers.SupplierMapper;
import com.phpn.exceptions.NotFoundException;
import com.phpn.dto.suppliers.SupplierResult;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SupplierResult> findAll() {
        if (supplierRepository.findAll().size() == 0) {
        }

        return supplierRepository
        .findAll()
        .stream()
        .map(supplier -> supplierMapper.toDTO(supplier))
        .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public SupplierResult findById(Integer id) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (!supplierOptional.isPresent()) throw new NotFoundException("Not found supplier with id: " + id);
        return supplierMapper.toDTO(supplierOptional.get());
    }

    @Override
    public void deleteById(Integer id) {
        findById(id);
        supplierRepository.deleteById(id);
    }

}