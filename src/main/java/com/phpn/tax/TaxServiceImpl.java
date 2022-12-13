package com.phpn.tax;

import com.phpn.product.dto.ProductResult;
import com.phpn.tax.dto.TaxMapper;
import com.phpn.tax.dto.TaxParam;
import com.phpn.tax.dto.TaxResult;
import com.phpn.tax.product_tax.ProductTaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fx.qh.sapo.entities.product.tax.Tax;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
                .map(taxMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Tax findById(Integer id) {
        return taxRepository.findById(id).get();
    }

    @Override
    @Transactional
    public TaxResult create(TaxParam taxParam) {
        return taxMapper.toDTO(taxRepository.save(taxMapper.toModel(taxParam)));
    }

    @Override
    public List<TaxResult> findAllByProductId(List<ProductTaxResult> productTaxResults) {
        List<TaxResult> result = new ArrayList<>();
        for (ProductTaxResult productTaxResult : productTaxResults) {
            result.add(taxMapper.toDTO(taxRepository.findById(productTaxResult.getTaxId()).get()));
        }
        return result;
    }
}
