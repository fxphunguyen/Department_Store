package com.phpn.media;

import com.phpn.product.ProductMapper;
import com.phpn.product.dto.ProductResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fx.qh.sapo.entities.media.Media;
import vn.fx.qh.sapo.entities.product.Product;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductImageServiceImpl implements MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private MediaMapper mediaMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<MediaResult> findAllById(Integer productId) {
        List<MediaResult> mediaResults = mediaRepository.findAllById(productId).stream().map(mediaMapper ::toDTO).collect(Collectors.toList());
        return mediaResults;
    }

    @Override
    @Transactional
    public List<MediaResult> save(List<MediaParam> mediaParam, Product productSaved) {
        List<Media> medias = mediaParam.stream().map(mediaMapper :: toModel).collect(Collectors.toList());
        List<MediaResult> mediaResults = new ArrayList<>();
        for( int i = 0; i < medias.size(); i++ ) {
            Media media = new Media();
            media = medias.get(i);
            if(i == 0) {
                media.setIsMain(true);
            } else {
                media.setIsMain(false);
            }
            media.setProductId(productSaved.getId());
            media.setProduct(productSaved);
            Media mediaSaved = mediaRepository.save(media);
            mediaResults.add(mediaMapper.toDTO(mediaSaved));
        }
        return mediaResults;
    }

    @Override
    public List<MediaResult> save(List<MediaParam> mediaParam, Integer idProduct) {
        return null;
    }

    @Override
    public String getLinkMediaByProductIdIsMain(Integer productId) {
        return mediaRepository.getLinkMediaByProductIdIsMain(productId).orElse("");
    }
}
