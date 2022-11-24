package com.phpn.services.suppliers;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.phpn.mappers.SupplierMapper;
import com.phpn.mappers.localtionRegion.LocationRegionMapper;
import com.phpn.repositories.SupplierRepository;
import com.phpn.repositories.LocationRegionRepository;
import com.phpn.repositories.model.Supplier;
import com.phpn.dto.suppliers.SupplierResult;
import com.phpn.dto.suppliers.SupplierCreate;
import com.phpn.exceptions.NotFoundException;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private LocationRegionMapper locationRegionMapper;

    @Autowired
    private LocationRegionRepository locationRegionRepository;

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
    public Supplier save(@NotNull SupplierCreate supplierCreate) {
        locationRegionRepository.save(locationRegionMapper.toModel(supplierCreate.getLocationRegionCreate()));
        return supplierRepository.save(supplierMapper.toModel(supplierCreate));
    }

    @Override
    public void deleteById(Integer id) {
        findById(id);
        supplierRepository.deleteById(id);
    }

}