package com.phpn.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fx.qh.sapo.entities.media.Media;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductImageServiceImpl implements MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private MediaMapper mediaMapper;

    @Override
    public List<MediaResult> save(List<MediaParam> mediaParam, Integer idProduct) {
        List<Media> medias = mediaParam.stream().map(mediaMapper :: toModel).collect(Collectors.toList());
        List<MediaResult> mediaResults = new ArrayList<>();
        for( int i = 0; i < medias.size(); i++ ) {
            Media media = new Media();
            if(i == 0) {
                media.setIsMain(true);
            } else {
                media.setIsMain(false);
            }
            media.setProductId(idProduct);
            mediaResults.add(mediaMapper.toDTO(mediaRepository.save(media)));
        }
        return mediaResults;
    }
}
