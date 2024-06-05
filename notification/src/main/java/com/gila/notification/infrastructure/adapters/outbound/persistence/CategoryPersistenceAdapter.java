package com.gila.notification.infrastructure.adapters.outbound.persistence;

import com.gila.notification.application.port.outbound.CategoryPersistencePort;
import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.CategoryNotifications;
import com.gila.notification.domain.ports.CategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {

    private final CategoryRepository categoryRepository;

    @Override
    public Optional<CategoryNotifications> getCategoryById(String category) { 
        return categoryRepository.findByCategory(category);

    }
    @Override
    public List<Category> getClientByAll() {

        return categoryRepository.findAll();
    }



}