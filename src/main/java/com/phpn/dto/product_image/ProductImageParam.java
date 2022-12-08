package com.phpn.dto.product_image;

import com.phpn.repositories.model.Product;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Accessors(chain = true)
public class ProductImageParam {

    private String cloudId;
    private String fileName;
    private String fileFolder;
    private String fileUrl;
    private String fileType;
    private Boolean deleted = false;
    private Integer productId;
    private Product product;
}
