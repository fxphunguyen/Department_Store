package com.phpn.brand;

import org.springframework.stereotype.Component;

import vn.fx.qh.sapo.entities.product.*;

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