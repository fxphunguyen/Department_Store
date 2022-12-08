package com.phpn.mappers.media;

import com.phpn.dto.product_image.ProductImageParam;
import vn.fx.qh.sapo.entities.ProductImage;

import java.time.LocalDate;
import java.util.Date;

public class MediaMapper {

    public ProductImage toModel(ProductImageParam productImageParam) {
        return new ProductImage(productImageParam.getProduct())
                .setCloudId(productImageParam.getCloudId())
                .setFileName(productImageParam.getFileName())
                .setFileFolder(productImageParam.getFileFolder())
                .setFileUrl(productImageParam.getFileUrl())
                .setFileType(productImageParam.getFileType())
                .setCreatedAt(new Date(LocalDate.now().toString()))
                .setCreatedBy(null)
                .setUpdatedAt(null)
                .setUpdatedBy(null)
                .setDeleted(false)
                .setProductId(productImageParam.getProductId());
    }
}
