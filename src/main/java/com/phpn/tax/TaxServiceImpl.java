package com.phpn.tax;

import com.phpn.product.dto.ProductResult;
import com.phpn.tax.dto.TaxMapper;
import com.phpn.tax.dto.TaxParam;
import com.phpn.tax.dto.TaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fx.qh.sapo.entities.product.tax.Tax;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxServiceImpl implements TaxService {
    @Autowired
    TaxRepository taxRepository;

    @Autowired
    TaxMapper taxMapper;

    @Override
    @Transactional
    public List<TaxResult> findAllTax() {
        return taxRepository.findAll()
                .stream()
                .map(tax -> {
                    Integer productId = tax.getId();
                    TaxResult dto = taxMapper.toDTO(tax);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TaxResult create(TaxParam taxParam) {
        return taxMapper.toDTO(taxRepository.save(taxMapper.toModel(taxParam)));
    }
}
