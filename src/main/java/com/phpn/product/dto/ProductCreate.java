package com.phpn.product.dto;

import com.phpn.brand.dto.BrandResult;
import com.phpn.category.dto.CategoryResult;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;
import vn.fx.qh.sapo.entities.product.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;


@Data
@Accessors(chain = true)
public class ProductCreate implements Serializable {
    private Integer id;
    private String title;
    private String image;
    private Instant createAt;
    private Instant updateAt;
    private String description;
    private String unit;
    private String sku;
    private String barCode;
    private Integer quantity;
    private BigDecimal retailPrice;
    private BigDecimal importPrice;
    private BigDecimal wholesalePrice;
    private Integer categoryId;
    private Integer brandId;
    private String fileName;
    private String fileFolder;
    private String fileUrl;
    private String cloudId;
    private String fileProductId;
    private MultipartFile file;
    private String fileType;
}
