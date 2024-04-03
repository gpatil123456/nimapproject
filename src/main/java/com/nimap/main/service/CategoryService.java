package com.nimap.main.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.main.entity.Category;

@Service
public interface CategoryService {
    Page<Category> getAllCategories(Pageable pageable);

    Category getCategoryById(Long id);

    Category createCategory(Category category);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);
}