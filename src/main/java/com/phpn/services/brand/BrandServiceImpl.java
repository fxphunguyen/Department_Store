package com.phpn.services.brand;

import com.phpn.mappers.BrandMapper;
import com.phpn.repositories.BrandRepository;

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

}