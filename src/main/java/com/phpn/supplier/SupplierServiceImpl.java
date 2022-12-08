package com.phpn.supplier;

import com.phpn.exceptions.AppNotFoundException;
import com.phpn.exceptions.NotFoundException;
import com.phpn.exceptions.VersionException;
import com.phpn.application.ApplicationRepository;
import vn.fx.qh.sapo.entities.Application;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.fx.qh.sapo.entities.product.supplier.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService, InitializingBean {

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

    @Autowired
    ApplicationRepository applicationRepository;
    @Value("${web.app.version-code}")
    int appVersionCode;
    @Value("${web.app.key}")
    String appKey;

    //ANH CU VIET CAM XOA
    @Override
    public void afterPropertiesSet() throws Exception {
        Optional<Application> appOpt = applicationRepository.findAllByAppKey(appKey);
        if (!appOpt.isPresent())
            throw new AppNotFoundException("Ban can cai dat mot ung dung");
        Application app = appOpt.get();
        if (!app.getVersionCode().equals(appVersionCode))
            throw new VersionException("BAN CAN CAI DAT PHIEN BAN CODE MOI (TOM LAI LA MERGE CODE)");
    }
}