package com.phpn.services.suppliers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.phpn.dto.suppliers.SupplierCreate;
import com.phpn.dto.suppliers.SupplierResult;
import com.phpn.mappers.SupplierMapper;
import com.phpn.mappers.localtionRegion.LocationRegionMapper;
import com.phpn.repositories.SupplierRepository;
import com.phpn.repositories.LocationRegionRepository;
import com.phpn.repositories.model.Supplier;
import com.phpn.repositories.model.LocationRegion;
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
        List<SupplierResult> supplierResults = supplierRepository
        .findAll()
        .stream()
        .map(supplier -> supplierMapper.toDTO(supplier))
        .collect(Collectors.toList());

        if (supplierResults.isEmpty()) throw new NotFoundException("Not found supplier data or is empty!");
        return supplierResults;
    }

    @Override
    @Transactional(readOnly = true)
    public SupplierResult findById(Integer id) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (!supplierOptional.isPresent()) throw new NotFoundException("Not found supplier with id: " + id);
        return supplierMapper.toDTO(supplierOptional.get());
    }

    @Override
    public Supplier save(SupplierCreate supplierCreate) { // CURRENT NOT WORKING !!!
        LocationRegion locationRegion = locationRegionMapper.toModel(supplierCreate.getLocationRegionCreate());
        System.out.println(locationRegion);
        locationRegionRepository.save(locationRegion);
        LocationRegion idLocationRegionCr = locationRegionRepository.findMaxIdCustomer();
        System.out.println(locationRegion.getId());
        supplierCreate.setLocationRegionId(idLocationRegionCr.getId());
        return   supplierRepository.save(supplierMapper.toModel(supplierCreate));
    }

    @Override
    public void deleteById(Integer id) {
        findById(id);
        supplierRepository.deleteById(id);
    }

}