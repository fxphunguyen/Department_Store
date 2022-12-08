package com.phpn.product.category;

import vn.fx.qh.sapo.entities.Category;
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
    public Category create(CategoryParam categoryParam) {
        return categoryRepository.save(categoryMapper.toModel(categoryParam));
    }
}