package com.phpn.services.product;

import java.util.List;

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
    public List<?> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public Product create(Product product) {
        return null;
    }

}