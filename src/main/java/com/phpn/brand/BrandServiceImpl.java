package com.phpn.brand;

import com.phpn.brand.dto.BrandMapper;
import com.phpn.brand.dto.BrandParam;
import com.phpn.brand.dto.BrandResult;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vn.fx.qh.sapo.entities.product.Brand;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<BrandResult> findAll() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandResult> brandResults = new ArrayList<>();
        for(Brand brand : brands){
            brandResults.add(brandMapper.toDTO(brand));
        }
        return brandResults;
    }
}