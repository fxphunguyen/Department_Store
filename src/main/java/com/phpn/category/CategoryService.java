package com.phpn.product.category;
import vn.fx.qh.sapo.entities.product.*;
import com.phpn.product.category.CategoryParam;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

//    public CategoryResult createCategoryResult(CategoryCreateParam categoryCreateParam);

    List<Category> findAll();

    Category getById(Integer id);

    Optional<Category> findById(Integer id);

    Category save(Category category);

    void remove(Integer id);

    Category create(CategoryParam categoryParam);
}
