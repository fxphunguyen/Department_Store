package com.phpn.media;


import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MediaService {
    List<MediaResult> save(List<MediaParam> mediaParam, Integer idProduct);
    String getLinkMediaByProductIdIsMain(Integer productId);
}
