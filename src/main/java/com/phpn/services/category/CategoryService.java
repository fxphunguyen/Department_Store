package com.phpn.services.category;

import com.phpn.dto.category.CategoryCreateParam;
import com.phpn.dto.category.CategoryResult;
import com.phpn.repositories.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

//    public CategoryResult createCategoryResult(CategoryCreateParam categoryCreateParam);

    List<Category> findAll();

    Category getById(Integer id);

    Optional<Category> findById(Integer id);

    Category save(Category category);

    void remove(Integer id);
}
