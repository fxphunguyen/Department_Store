package com.phpn.mappers.brand;

import org.springframework.stereotype.Component;

import com.phpn.dto.brand.BrandParam;
import com.phpn.dto.brand.BrandResult;
import com.phpn.dto.brand.BrandCreateParam;
import com.phpn.repositories.model.Brand;

@Component
public class BrandMapper {

    public BrandResult toDTO(Brand brand) {
        return new BrandResult()
        .setId(brand.getId())
        .setName(brand.getName());
    }

    public Brand toModel(BrandParam brandParam) {
        return new Brand()
        .setId(brandParam.getId())
        .setName(brandParam.getName());
    }

    public Brand toModel(BrandCreateParam brandCreateParam) {
        return new Brand().setName(brandCreateParam.getName());
    }

}