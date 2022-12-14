package com.phpn.media;

import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.media.Media;
import vn.fx.qh.sapo.entities.product.Product;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Component
public class MediaMapper {

    public vn.fx.qh.sapo.entities.media.Media toModel(MediaParam productImageParam) {
        return new vn.fx.qh.sapo.entities.media.Media()
                .setCloudId(productImageParam.getCloudId())
                .setFileName(productImageParam.getFileName())
                .setFileFolder(productImageParam.getFileFolder())
                .setFileUrl(productImageParam.getFileUrl())
                .setFileType(productImageParam.getFileType());
    }

    public MediaResult toDTO(Media media) {
        return new MediaResult()
                .setCloudId(media.getCloudId())
                .setFileName(media.getFileName())
                .setFileFolder(media.getFileFolder())
                .setFileUrl(media.getFileUrl())
                .setFileType(media.getFileType())
                .setIsMain(media.getIsMain())
                .setProductId(media.getProductId())
                .setCreatedAt(media.getCreatedAt())
                .setUpdatedAt(media.getUpdatedAt());
    }
}
