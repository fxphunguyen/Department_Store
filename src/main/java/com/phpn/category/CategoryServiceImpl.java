package com.phpn.category;

import com.phpn.category.dto.CategoryMapper;
import com.phpn.category.dto.CategoryParam;
import com.phpn.category.dto.CategoryResult;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vn.fx.qh.sapo.entities.product.Category;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResult> findAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResult> categoryResults = new ArrayList<>();
        for(Category category : categories){
            categoryResults.add(categoryMapper.toDTO(category));
        }
        return categoryResults;
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).get();
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
    public Category create(CategoryParam categoryParam) {
        return categoryRepository.save(categoryMapper.toModel(categoryParam));
    }
}