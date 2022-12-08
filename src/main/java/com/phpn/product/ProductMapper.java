package com.phpn.product;
import com.phpn.brand.dto.BrandMapper;
import com.phpn.product.dto.ProductParam;
import com.phpn.product.dto.ProductResult;
import com.phpn.product.dto.ProductShortParam;
import com.phpn.product.dto.ProductWithImageParam;
import com.phpn.category.dto.CategoryMapper;
import com.phpn.product.item.ItemMapper;
import vn.fx.qh.sapo.entities.product.*;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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
                .setCategoryId(productParam.getCategoryId());
    }

    public Product toModel(ProductWithImageParam productWithImageParam) {
        return new Product(productWithImageParam.getCategoryId(),productWithImageParam.getBrandId())
                .setTitle(productWithImageParam.getTitle())
                .setStatus(productWithImageParam.getStatus())
                .setCreateAt(java.time.LocalDateTime.now().toString())
                .setUpdateAt(null)
                .setDescription(productWithImageParam.getDescription())
                .setUnit(productWithImageParam.getUnit())
                .setSku(productWithImageParam.getSku())
                .setBarCode(productWithImageParam.getBarCode())
                .setImportPrice(productWithImageParam.getImportPrice())
                .setRetailPrice(productWithImageParam.getRetailPrice())
                .setWholesalePrice(productWithImageParam.getWholesalePrice())
                .setBrandId(productWithImageParam.getBrandId())
                .setCategoryId(productWithImageParam.getCategoryId());
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
//                .setTax((Tax) product.getTaxs());
//                        .setBrandResult(brandMapper.toDTO(product.getBrand()))
//                .setCategoryResult(categoryMapper.toDTO(product.getCategory()));
    }


    public Product toModel(ProductShortParam productShortParam) {
        return new Product(Integer.parseInt(productShortParam.getCategoryId()))
                .setId(Integer.parseInt(productShortParam.getId()))
                .setTitle(productShortParam.getTitle())
                .setSku(productShortParam.getSku())
                .setCategoryId(Integer.parseInt(productShortParam.getCategoryId()))
                .setRetailPrice(new BigDecimal(Integer.parseInt(productShortParam.getRetailPrice())))
                .setSku(productShortParam.getSku())
                .setImportPrice(new BigDecimal(Integer.parseInt(productShortParam.getImportPrice())));

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
