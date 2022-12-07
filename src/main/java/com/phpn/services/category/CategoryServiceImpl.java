package com.phpn.services.category;

import com.phpn.dto.category.CategoryParam;
import com.phpn.mappers.CategoryMapper;
import com.phpn.repositories.CategoryRepository;

import com.phpn.repositories.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(CategoryParam categoryParam) {
        return categoryRepository.save(categoryMapper.toModel(categoryParam));
    }
}