package com.phpn.services.product_image;

import com.phpn.dto.product_image.ProductImageParam;
import com.phpn.repositories.ProductImageRepository;
import com.phpn.repositories.model.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductImageServiceImpl implements ProductImageService{

    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public ProductImage save(ProductImageParam productImageParam) {
        return null;
    }
}
