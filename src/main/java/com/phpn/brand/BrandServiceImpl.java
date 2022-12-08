package com.phpn.brand;

import vn.fx.qh.sapo.entities.Brand;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand create(BrandParam brandParam) {
        return brandRepository.save(brandMapper.toModel(brandParam));
    }
}