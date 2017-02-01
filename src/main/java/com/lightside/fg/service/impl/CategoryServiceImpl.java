package com.lightside.fg.service.impl;

import com.lightside.fg.domain.ProductCategory;
import com.lightside.fg.repository.CategoryRepository;
import com.lightside.fg.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Created by achirakkattil on 12/3/16.
 */

@Component
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<ProductCategory> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
