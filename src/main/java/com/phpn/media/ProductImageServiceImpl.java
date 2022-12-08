package com.phpn.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductImageServiceImpl implements MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Override
    public MediaResult save(MediaParam mediaParam) {
        return null;
    }
}
