package com.phpn.controllers.api;

<<<<<<< HEAD
import com.phpn.repositories.CategoryRepository;
import com.phpn.repositories.model.Category;
=======

import com.phpn.repositories.CategoryRepository;
import com.phpn.repositories.model.Category;
import com.phpn.services.category.CategoryServiceImpl;
>>>>>>> dev_c5
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

=======
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
>>>>>>> dev_c5
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesAPI {

    @Autowired
    CategoryRepository categoryRepository;

<<<<<<< HEAD
    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<?> showAllCategory(){
        List<Category> categories =  categoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
=======
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
>>>>>>> dev_c5
}
