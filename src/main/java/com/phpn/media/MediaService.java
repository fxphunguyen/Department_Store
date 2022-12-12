package com.phpn.media;


import java.util.List;

public interface MediaService {
    List<MediaResult> save(List<MediaParam> mediaParam, Integer idProduct);
}
