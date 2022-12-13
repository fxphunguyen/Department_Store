package com.phpn.product;

import com.phpn.brand.dto.BrandMapper;
import com.phpn.product.dto.*;
import com.phpn.category.dto.CategoryMapper;
import com.phpn.tax.dto.TaxMapper;
import com.phpn.tax.dto.TaxResult;
import vn.fx.qh.sapo.entities.product.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {


    @Autowired
    BrandMapper brandMapper;

    @Autowired
    TaxMapper taxMapper;

    @Autowired
    CategoryMapper categoryMapper;

    public Product toModel(ProductParam productParam) {
        return new Product(productParam.getCategoryId(), productParam.getBrandId())
                .setTitle(productParam.getTitle())
                .setImage(productParam.getImage())
                .setStatus(productParam.getStatus())

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

    public Product toModel(CreateProductParam productWithImageParam) {
        return new Product(productWithImageParam.getCategoryId(), productWithImageParam.getBrandId())
                .setTitle(productWithImageParam.getTitle())
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
                .setDescription(product.getDescription())
                .setUnit(product.getUnit())
                .setCreateAt(product.getCreatedAt())
                .setUpdateAt(product.getUpdatedAt())
                .setImportPrice(product.getImportPrice())
                .setWholesalePrice(product.getWholesalePrice())
                .setRetailPrice(product.getRetailPrice());
//        List<TaxResult> taxSaleList = product.getTaxSale().stream().map(taxMapper::toDTO).collect(Collectors.toList());
//        result.setTaxSaleList(taxSaleList);
//        List<TaxResult> taxPurchaseList = product.getTaxPurchase().stream().map(taxMapper::toDTO).collect(Collectors.toList());
//        result.setTaxPurchaseList(taxPurchaseList);
//        result.setBrand(brandMapper.toDTO(product.getBrand()))
//                .setCategory(categoryMapper.toDTO(product.getCategory()));
    }

    public ProductDetailResult toDTODetail(Product product) {
        return new ProductDetailResult()
                .setId(product.getId())
                .setTitle(product.getTitle())
                .setStatus(product.getStatus())
                .setBarCode(product.getBarCode())
                .setSku(product.getSku())
                .setDescription(product.getDescription())
                .setUnit(product.getUnit())
                .setCreateAt(product.getCreatedAt())
                .setUpdateAt(product.getUpdatedAt())
                .setImportPrice(product.getImportPrice())
                .setWholesalePrice(product.getWholesalePrice())
                .setRetailPrice(product.getRetailPrice())
                .setApplyTax(product.getApplyTax())
                .setIsTaxInclusive(product.getIsTaxInclusive());
    }

    public ProductItemResult toDTOPage(Product product) {
        return new ProductItemResult()
                .setId(product.getId())
                .setTitle(product.getTitle())
                .setImage(product.getImage())
                .setStatus(product.getStatus())
                .setAvailable(0)
                .setInventory(0)
                .setCategory(categoryMapper.toDTO(product.getCategory()))
                .setBrand(brandMapper.toDTO(product.getBrand()));
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
