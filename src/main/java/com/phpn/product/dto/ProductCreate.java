package com.phpn.dto.product;

import com.phpn.dto.brand.BrandResult;
import com.phpn.dto.category.CategoryResult;
import vn.fx.qh.sapo.entities.ProductStatus;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@Accessors(chain = true)
public class ProductCreate implements Serializable {
    private Integer id;
    private String title;
    private String image;
    private ProductStatus status;
    private String createAt;
    private String updateAt;
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
    private CategoryResult categoryResult;
    private BrandResult brandResult;
    private String fileName;

    private String fileFolder;

    private String fileUrl;

    private String cloudId;

    private String fileProductId;

    private MultipartFile file;

    private String fileType;
}
