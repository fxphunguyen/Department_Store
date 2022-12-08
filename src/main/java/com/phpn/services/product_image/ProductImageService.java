package com.phpn.services.product_image;

import com.phpn.dto.product_image.ProductImageParam;
import com.phpn.repositories.model.ProductImage;

public interface ProductImageService {
    ProductImage save(ProductImageParam productImageParam);
}
