package com.phpn.controllers.api;


import com.phpn.brand.BrandParam;
import com.phpn.brand.BrandRepository;
import vn.fx.qh.sapo.entities.product.*;
import com.phpn.brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandAPI {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    BrandService brandService;

    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<?> showAllBrand(){
        List<Brand> brands =  brandRepository.findAll();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createBrand(@RequestBody BrandParam brandParam){
        Brand brand = brandService.create(brandParam);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }
}
