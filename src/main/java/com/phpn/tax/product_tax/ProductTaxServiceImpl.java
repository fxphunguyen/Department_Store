package com.phpn.tax.product_tax;

import com.phpn.product.ProductTaxRepository;
import com.phpn.tax.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fx.qh.sapo.entities.product.Product;
import vn.fx.qh.sapo.entities.product.tax.ProductTax;
import vn.fx.qh.sapo.entities.product.tax.ProductTaxId;
import vn.fx.qh.sapo.entities.product.tax.Tax;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductTaxServiceImpl implements ProductTaxService{
    @Autowired
    ProductTaxRepository productTaxRepository;

    @Autowired
    TaxService taxService;

    @Autowired
    ProductTaxMapper productTaxMapper;

    @Override
    @Transactional
    public List<ProductTaxResult> create(List<ProductTaxParam> productTaxParams, Product product) {
        List<ProductTaxResult> productTaxResults = new ArrayList<>();
        for (ProductTaxParam productTaxParam : productTaxParams) {
            Tax tax = taxService.findById(productTaxParam.getTaxId());
            ProductTax productTax = productTaxMapper.toModel(productTaxParam, product);
            ProductTaxId productTaxId = new ProductTaxId();
            productTaxId.setProduct(product);
            productTaxId.setTax(tax);
            productTax.setId(productTaxId);
            productTaxResults.add(productTaxMapper.toDTO(productTaxRepository.save(productTax)));
        }
        System.out.println(productTaxResults);
        return productTaxResults;
    }

    @Override
    public List<ProductTaxResult> findAllByProductId(Integer productId) {
        List<ProductTaxResult> productTaxResults = productTaxRepository.findAllByProductId(productId).stream().map(productTaxMapper :: toDTO).collect(Collectors.toList());
        return productTaxResults;
    }
}
