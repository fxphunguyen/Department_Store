package com.phpn.services.category;

import com.phpn.dto.category.CategoryParam;
import com.phpn.repositories.model.Category;

public interface CategoryService {

    Category create(CategoryParam categoryParam);
}
