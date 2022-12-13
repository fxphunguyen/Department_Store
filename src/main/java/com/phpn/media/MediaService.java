package com.phpn.media;

import vn.fx.qh.sapo.entities.product.Product;
import java.util.List;

public interface MediaService {
    List<MediaResult> findAllById(Integer productId);
    List<MediaResult> save(List<MediaParam> mediaParam, Product productSaved);

    List<MediaResult> save(List<MediaParam> mediaParam, Integer idProduct);
    String getLinkMediaByProductIdIsMain(Integer productId);
}
