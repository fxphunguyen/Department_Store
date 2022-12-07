package com.phpn.controllers.api;


import com.phpn.repositories.BrandRepository;
import com.phpn.repositories.CategoryRepository;
import com.phpn.repositories.model.Brand;
import com.phpn.repositories.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandAPI {

    @Autowired
    BrandRepository brandRepository;

    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<?> showAllBrand(){
        List<Brand> brands =  brandRepository.findAll();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

}
