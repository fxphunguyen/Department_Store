package com.phpn.services.product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.phpn.dto.product.ProductCreate;
import com.phpn.dto.product.ProductParam;
import com.phpn.dto.product.ProductResult;
import com.phpn.mappers.product.ProductMapper;
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
    public List<ProductResult> showAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(product -> productMapper.toDTO(product))
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
    public ProductResult findByIdProduct(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
       return productMapper.toDTO(productOptional.get());
    }

    @Override
    public Product create(ProductParam productParam) {
        return productRepository.save(productMapper.toModel(productParam));
    }


    @Override
    public Product createProduct(ProductCreate productCreate) {
//
//        String fileType = productCreate.getFile().getContentType();
//
//        assert fileType != null;
//
//        fileType = fileType.substring(0, 5);
//
//        productCreate.setFileType(fileType);
//
//        Product product = productRepository.save(productMapper.toProduct(productCreate));
//
//        return product;
        return  null;
    }

}