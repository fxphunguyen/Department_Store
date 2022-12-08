package com.phpn.media;

import lombok.Data;
import lombok.experimental.Accessors;
import vn.fx.qh.sapo.entities.product.Product;

@Data
@Accessors(chain = true)
public class MediaParam {
    private String cloudId;
    private String fileName;
    private String fileFolder;
    private String fileUrl;
    private String fileType;
}
