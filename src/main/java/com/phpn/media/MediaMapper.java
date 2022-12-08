package com.phpn.media;

import org.springframework.stereotype.Component;

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
                .setFileType(productImageParam.getFileType())
                .setCreatedAt(new Date(LocalDate.now().toString()))
                .setCreatedBy(null)
                .setUpdatedAt(null)
                .setUpdatedBy(null);
    }
}
