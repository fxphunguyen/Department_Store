package com.phpn.services.product;

import java.util.List;
import java.util.stream.Collectors;

import com.phpn.dto.product.ProductCreateParam;
import com.phpn.dto.product.ProductParam;
import com.phpn.dto.product.ProductResult;
import com.phpn.mappers.ProductMapper;
import com.phpn.repositories.model.Product;
import com.phpn.repositories.ProductRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
     ProductMapper productMapper;

    @Autowired
     ProductRepository productRepository;

    @Override
    public List<ProductResult> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper :: toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResult> findAllProductByDeleted(boolean deleted) {
        return productRepository.findAllProductByDeleted(deleted)
                .stream()
                .map(productMapper :: toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public Product create(ProductCreateParam productCreateParam) {
        return null;
    }

}