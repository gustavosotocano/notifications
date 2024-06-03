package com.gila.notification.infrastructure.adapters.repositories;

import com.gila.notification.domain.exception.CategoryNotFoundException;
import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.CategoryNotifications;
import com.gila.notification.domain.ports.CategoryRepository;
import com.gila.notification.infrastructure.adapters.outbound.persistence.mapper.CategoryPersistenceMapper;
import com.gila.notification.infrastructure.repositories.CategoryJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepositoryRepository;
    private final CategoryPersistenceMapper categoryPersistenceMapper;

    public CategoryRepositoryImpl(CategoryJpaRepository categoryJpaRepositoryRepository,
                                  CategoryPersistenceMapper categoryPersistenceMapper) {
        this.categoryJpaRepositoryRepository = categoryJpaRepositoryRepository;
        this.categoryPersistenceMapper = categoryPersistenceMapper;
    }

    @Override
    public List<Category> findAll() {
        return categoryJpaRepositoryRepository.findAll().stream().map(categoryPersistenceMapper::toModel).toList();
    }

    @Override
    public Optional<CategoryNotifications> findById(String categoryName) {
        return Optional.ofNullable(categoryPersistenceMapper
                                           .toModelCategoryNotifications(categoryJpaRepositoryRepository.findById(categoryName)
                                                            .orElseThrow(() -> new CategoryNotFoundException(
                                                                    "category not found - " + categoryName))));
    }

}
