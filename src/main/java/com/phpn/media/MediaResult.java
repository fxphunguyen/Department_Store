package com.phpn.media;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import vn.fx.qh.sapo.entities.product.Product;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Accessors(chain = true)
public class MediaResult {

    private String cloudId;
    private String fileName;
    private String fileFolder;
    private String fileUrl;
    private String fileType;
    private Boolean isMain;
    private Instant createdAt;
    private Instant updatedAt;
    private Integer productId;
}
