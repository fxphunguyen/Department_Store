package com.phpn.mappers;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.phpn.dto.product.ProductParam;
import com.phpn.dto.product.ProductResult;
import com.phpn.dto.product.ProductCreateParam;
import com.phpn.dto.product.ProductUpdateParam;
import com.phpn.repositories.model.Product;

@Component
public class ProductMapper {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    public ProductResult toDTO(Product product) {
        return new ProductResult()
        .setId(product.getId())
        .setTitle(product.getTitle())
        .setImage(product.getImage())
        .setStatus(product.getStatus())
        .setCreateAt(product.getCreateAt())
        .setUpdateAt(product.getUpdateAt())
        .setDescription(product.getDescription())
        .setUnit(product.getUnit())
        .setSku(product.getSku())
        .setBarCode(product.getBarCode())
        .setQuantity(product.getQuantity())
        .setRetailPrice(product.getRetailPrice())
        .setImportPrice(product.getImportPrice())
        .setWholesalePrice(product.getWholesalePrice())
        .setCategoryId(product.getCategoryId())
        .setBrandId(product.getBrandId())
        .setDeleted(product.getDeleted());
    }

    public Product toModel(ProductParam productParam) {
        return new Product(productParam.getBrandId(), productParam.getCategoryId())
        .setId(productParam.getId())
        .setTitle(productParam.getTitle())
        .setImage(productParam.getImage())
        .setStatus(productParam.getStatus())
        .setDescription(productParam.getDescription())
        .setUnit(productParam.getUnit())
        .setSku(productParam.getSku())
        .setBarCode(productParam.getBarCode())
        .setQuantity(productParam.getQuantity())
        .setRetailPrice(productParam.getRetailPrice())
        .setImportPrice(productParam.getImportPrice())
        .setWholesalePrice(productParam.getWholesalePrice())
        .setCategoryId(productParam.getCategoryId())
        .setBrandId(productParam.getBrandId())
        .setDeleted(productParam.getDeleted());
    }

    public Product toModel(ProductResult productResult) {
        return new Product(productResult.getBrandId(), productResult.getCategoryId())
        .setId(productResult.getId())
        .setTitle(productResult.getTitle())
        .setImage(productResult.getImage())
        .setStatus(productResult.getStatus())
        .setCreateAt(productResult.getCreateAt())
        .setUpdateAt(productResult.getUpdateAt())
        .setDescription(productResult.getDescription())
        .setUnit(productResult.getUnit())
        .setSku(productResult.getSku())
        .setBarCode(productResult.getBarCode())
        .setQuantity(productResult.getQuantity())
        .setRetailPrice(productResult.getRetailPrice())
        .setImportPrice(productResult.getImportPrice())
        .setWholesalePrice(productResult.getWholesalePrice())
        .setCategoryId(productResult.getCategoryId())
        .setBrandId(productResult.getBrandId())
        .setDeleted(productResult.getDeleted());
    }

    public Product toModel(ProductCreateParam productCreateParam) {
        return new Product(productCreateParam.getCategoryId(), productCreateParam.getCategoryId())
        .setTitle(productCreateParam.getTitle())
        .setImage(productCreateParam.getImage())
        .setStatus(productCreateParam.getStatus())
        .setDescription(productCreateParam.getDescription())
        .setUnit(productCreateParam.getUnit())
        .setSku(productCreateParam.getSku())
        .setBarCode(productCreateParam.getBarCode())
        .setQuantity(productCreateParam.getQuantity())
        .setRetailPrice(productCreateParam.getRetailPrice())
        .setImportPrice(productCreateParam.getImportPrice())
        .setWholesalePrice(productCreateParam.getWholesalePrice())
        .setCategoryId(productCreateParam.getCategoryId())
        .setBrandId(productCreateParam.getBrandId())
        .setDeleted(productCreateParam.getDeleted());
    }

    public Product toModel(ProductUpdateParam productUpdateParam) {
        return new Product(productUpdateParam.getCategoryId(), productUpdateParam.getCategoryId())
        .setTitle(productUpdateParam.getTitle())
        .setImage(productUpdateParam.getImage())
        .setStatus(productUpdateParam.getStatus())
        .setDescription(productUpdateParam.getDescription())
        .setUnit(productUpdateParam.getUnit())
        .setSku(productUpdateParam.getSku())
        .setBarCode(productUpdateParam.getBarCode())
        .setQuantity(productUpdateParam.getQuantity())
        .setRetailPrice(productUpdateParam.getRetailPrice())
        .setImportPrice(productUpdateParam.getImportPrice())
        .setWholesalePrice(productUpdateParam.getWholesalePrice())
        .setCategoryId(productUpdateParam.getCategoryId())
        .setBrandId(productUpdateParam.getBrandId())
        .setDeleted(productUpdateParam.getDeleted());
    }

    public ProductCreateParam toProductCreateParamDTO(Product product) {
        return new ProductCreateParam()
                .setTitle(product.getTitle())
                .setImage(product.getImage())
                .setStatus(product.getStatus())
                .setDescription(product.getDescription())
                .setUnit(product.getUnit())
                .setSku(product.getSku())
                .setBarCode(product.getBarCode())
                .setQuantity(product.getQuantity())
                .setRetailPrice(product.getRetailPrice())
                .setImportPrice(product.getImportPrice())
                .setWholesalePrice(product.getWholesalePrice())
                .setCategoryId(product.getCategoryId())
                .setBrandId(product.getBrandId())
                .setDeleted(product.getDeleted());
    }

    public ProductUpdateParam toProductUpdateParamDTO(Product product) {
        return new ProductUpdateParam()
                .setTitle(product.getTitle())
                .setImage(product.getImage())
                .setStatus(product.getStatus())
                .setDescription(product.getDescription())
                .setUnit(product.getUnit())
                .setSku(product.getSku())
                .setBarCode(product.getBarCode())
                .setQuantity(product.getQuantity())
                .setRetailPrice(product.getRetailPrice())
                .setImportPrice(product.getImportPrice())
                .setWholesalePrice(product.getWholesalePrice())
                .setCategoryId(product.getCategoryId())
                .setBrandId(product.getBrandId())
                .setDeleted(product.getDeleted());
    }

}