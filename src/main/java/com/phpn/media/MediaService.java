package com.phpn.media;


import com.phpn.product.dto.ProductResult;
import vn.fx.qh.sapo.entities.product.Product;

import java.util.List;

public interface MediaService {
    List<MediaResult> findAllById(Integer productId);
    List<MediaResult> save(List<MediaParam> mediaParam, Product productSaved);
}
