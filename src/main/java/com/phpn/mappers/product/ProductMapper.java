package com.phpn.mappers.product;

import com.phpn.dto.product.ProductParam;
import com.phpn.dto.product.ProductResult;
import com.phpn.repositories.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toModel(ProductParam productParam) {
        return new Product()
                .setId(productParam.getId())
                .setTitle(productParam.getTitle())
                .setBarCode(productParam.getBarCode())
                .setSku(productParam.getSku())
                .setBrandId(productParam.getBrandId())
                .setCategoryId(productParam.getCategoryId())
                .setImage(productParam.getImage())
                .setDescription(productParam.getDescription())
                .setImportPrice(productParam.getImportPrice())
                .setRetailPrice(productParam.getRetailPrice())
                .setWholesalePrice(productParam.getWholesalePrice())
                .setQuantity(productParam.getQuantity());
    }

    public ProductResult toDTO(Product product) {
        return new ProductResult()
                .setId(product.getId())
                .setTitle(product.getTitle())
                .setBarCode(product.getBarCode())
                .setSku(product.getSku())
                .setBrandId(product.getBrandId())
                .setCategoryId(product.getCategoryId())
                .setImage(product.getImage())
                .setDescription(product.getDescription())
                .setImportPrice(product.getImportPrice())
                .setWholesalePrice(product.getWholesalePrice())
                .setRetailPrice(product.getRetailPrice())
                .setQuantity(product.getQuantity())
                .setCreateAt(product.getCreateAt())
                .setUpdateAt(product.getUpdateAt());

    }
}
