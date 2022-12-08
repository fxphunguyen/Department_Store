package com.phpn.brand;

import com.phpn.brand.dto.BrandMapper;
import com.phpn.brand.dto.BrandParam;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vn.fx.qh.sapo.entities.product.Brand;

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