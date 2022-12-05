package com.phpn.mappers.product;

import com.phpn.dto.product.ProductCreate;
import com.phpn.dto.product.ProductParam;
import com.phpn.dto.product.ProductResult;
import com.phpn.mappers.CategoryMapper;
import com.phpn.mappers.brand.BrandMapper;
import com.phpn.mappers.item.ItemMapper;
import com.phpn.repositories.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ProductMapper {


    @Autowired
    BrandMapper brandMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    CategoryMapper categoryMapper;

    public Product toModel(ProductParam productParam) {
        return new Product(productParam.getCategoryId(),productParam.getBrandId())
                .setTitle(productParam.getTitle())
                .setImage(productParam.getImage())
                .setStatus(productParam.getStatus())
                .setCreateAt(java.time.LocalDateTime.now().toString())
                .setUpdateAt(null)
                .setDescription(productParam.getDescription())
                .setUnit(productParam.getUnit())
                .setSku(productParam.getSku())
                .setBarCode(productParam.getBarCode())
                .setImportPrice(productParam.getImportPrice())
                .setRetailPrice(productParam.getRetailPrice())
                .setWholesalePrice(productParam.getWholesalePrice())
                .setBrandId(productParam.getBrandId())
                .setCategoryId(productParam.getCategoryId())
                .setDeleted(true);
    }

    public ProductResult toDTO(Product product) {
        return new ProductResult()
                .setId(product.getId())
                .setTitle(product.getTitle())
                .setStatus(product.getStatus())
                .setBarCode(product.getBarCode())
                .setSku(product.getSku())
                .setBrandId(product.getBrandId())
                .setCategoryId(product.getCategoryId())
                .setImage(product.getImage())
                .setDescription(product.getDescription())
                .setImportPrice(product.getImportPrice())
                .setWholesalePrice(product.getWholesalePrice())
                .setRetailPrice(product.getRetailPrice())
                .setCreateAt(product.getCreateAt())
                .setUpdateAt(product.getUpdateAt());
//                .setBrandResult(brandMapper.toDTO(product.getBrand()))
//                .setCategoryResult(categoryMapper.toDTO(product.getCategory()));
    }

//    public ProductResult toItemDTO(Product product) {
//        return new ProductResult()
//                .setId(product.getId())
//                .setTitle(product.getTitle())
//                .setStatus(product.getStatus())
//                .setBarCode(product.getBarCode())
//                .setSku(product.getSku())
//                .setBrandId(product.getBrandId())
//                .setCategoryId(product.getCategoryId())
//                .setImage(product.getImage())
//                .setDescription(product.getDescription())
//                .setImportPrice(product.getImportPrice())
//                .setWholesalePrice(product.getWholesalePrice())
//                .setRetailPrice(product.getRetailPrice())
//                .setCreateAt(product.getCreateAt())
//                .setUpdateAt(product.getUpdateAt());
////                .setBrandResult(brandMapper.toDTO(product.getBrand()))
////                .setCategoryResult(categoryMapper.toDTO(product.getCategory()));
//    }


//    public Product toProduct(ProductCreate productCreate) {
//        return new Product()
//                .setId(productCreate.getId())
//                .setTitle(productCreate.getTitle())
//                .setImage(productCreate.getImage())
//                .setStatus(productCreate.getStatus())
//                .setCreateAt(java.time.LocalDateTime.now().toString())
//                .setUpdateAt(null)
//                .setDescription(productCreate.getDescription())
//                .setUnit(productCreate.getUnit())
//                .setSku(productCreate.getSku())
//                .setBarCode(productCreate.getBarCode())
//                .setImportPrice(productCreate.getImportPrice())
//                .setRetailPrice(productCreate.getRetailPrice())
//                .setWholesalePrice(productCreate.getWholesalePrice())
//                .setBrandId(productCreate.getBrandId())
//                .setCategoryId(productCreate.getCategoryId())
//                .setDeleted(true);
//    }

}
