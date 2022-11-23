package com.phpn.controllers.api;


import com.phpn.repositories.CategoryRepository;
import com.phpn.repositories.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesAPI {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("")
    public ResponseEntity<?> showAllCategory(){
        List<Category> categories =  categoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<?> createCategory(Category newCategory){
        Category category = categoryRepository.save(newCategory);
        return  new ResponseEntity<>(category, HttpStatus.OK);
    }
}
