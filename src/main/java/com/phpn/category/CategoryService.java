package com.phpn.category;
import com.phpn.category.dto.CategoryParam;
import com.phpn.category.dto.CategoryResult;
import vn.fx.qh.sapo.entities.product.*;

import java.util.List;

public interface CategoryService {

//    public CategoryResult createCategoryResult(CategoryCreateParam categoryCreateParam);

    List<CategoryResult> findAll();

    Category findById(Integer id);

    Category save(Category category);

    void remove(Integer id);

    Category create(CategoryParam categoryParam);
}
