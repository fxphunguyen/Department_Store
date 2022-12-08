package com.phpn.controllers.api;
import com.phpn.dto.category.CategoryParam;
import com.phpn.repositories.CategoryRepository;
import com.phpn.repositories.model.Category;
import com.phpn.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryAPI {
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<?> showAllCategory(){
        List<Category> categories =  categoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody CategoryParam categoryParam){
        Category category = categoryService.create(categoryParam);
        return  new ResponseEntity<>(category, HttpStatus.OK);
   }
}