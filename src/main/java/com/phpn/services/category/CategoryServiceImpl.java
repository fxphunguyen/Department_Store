package com.phpn.services.category;

import com.phpn.dto.category.CategoryCreateParam;
import com.phpn.dto.category.CategoryResult;
import com.phpn.mappers.CategoryMapper;
import com.phpn.repositories.CategoryRepository;

import com.phpn.repositories.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Integer id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        category.setId(0);
        return categoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {

    }

//    @Override
//    public CategoryResult createCategoryResult(CategoryCreateParam categoryCreateParam) {
//        return categoryMapper.toDTO(categoryRepository.save(categoryMapper.toModel(categoryCreateParam)));
//    }

}