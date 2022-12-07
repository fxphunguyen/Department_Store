package com.phpn.controllers.api;


import com.phpn.repositories.CategoryRepository;
import com.phpn.repositories.model.Category;
import com.phpn.services.category.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesAPI {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("")
    public ResponseEntity<?> showAllCategory(){
        List<Category> categories =  categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> addCategory(Category newCategory) {
        Category category = categoryService.save(newCategory);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
}
