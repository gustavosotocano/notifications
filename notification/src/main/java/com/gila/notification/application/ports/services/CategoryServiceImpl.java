package com.gila.notification.application.ports.services;

import com.gila.notification.application.ports.CategoryService;
import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.ports.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
