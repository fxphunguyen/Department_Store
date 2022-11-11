package com.phpn.mappers;

import org.springframework.stereotype.Component;

import com.phpn.dto.category.CategoryParam;
import com.phpn.dto.category.CategoryResult;
import com.phpn.dto.category.CategoryCreateParam;
import com.phpn.repositories.model.Category;

@Component
public class CategoryMapper {

    public CategoryResult toDTO(Category category) {
        return new CategoryResult()
        .setId(category.getId())
        .setName(category.getName());
    }

    public Category toModel(CategoryParam categoryParam) {
        return new Category()
        .setId(categoryParam.getId())
        .setName(categoryParam.getName());
    }

    public Category toModel(CategoryCreateParam categoryCreateParam) {
        return new Category().setName(categoryCreateParam.getName());
    }

}