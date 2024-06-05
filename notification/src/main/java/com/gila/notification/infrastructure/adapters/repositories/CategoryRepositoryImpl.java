package com.gila.notification.infrastructure.adapters.repositories;

import com.gila.notification.domain.exception.CategoryNotFoundException;
import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.CategoryNotifications;
import com.gila.notification.domain.ports.CategoryRepository;
import com.gila.notification.infrastructure.adapters.outbound.persistence.mapper.CategoryNotificationsPersistenceMapper;
import com.gila.notification.infrastructure.adapters.outbound.persistence.mapper.CategoryPersistenceMapper;
import com.gila.notification.infrastructure.outbound.persistence.repositories.CategoryJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepositoryRepository;
    private final CategoryNotificationsPersistenceMapper categoryNotificationsPersistenceMapper;
    private final CategoryPersistenceMapper categoryPersistenceMapper;

    public CategoryRepositoryImpl(CategoryJpaRepository categoryJpaRepositoryRepository,
                                  CategoryNotificationsPersistenceMapper categoryNotificationsPersistenceMapper,
                                  CategoryPersistenceMapper categoryPersistenceMapper) {
        this.categoryJpaRepositoryRepository = categoryJpaRepositoryRepository;
        this.categoryNotificationsPersistenceMapper = categoryNotificationsPersistenceMapper;
        this.categoryPersistenceMapper = categoryPersistenceMapper;
    }

    @Override
    public List<Category> findAll() {
        return categoryJpaRepositoryRepository.findAll().stream()
                .map(categoryPersistenceMapper::toModel)
                .toList();
    }

    @Override
    public Optional<CategoryNotifications> findByCategory(String categoryName) {
        return Optional.ofNullable(categoryNotificationsPersistenceMapper
                                           .toModelNotifications(categoryJpaRepositoryRepository.findById(categoryName)
                                                            .orElseThrow(() -> new CategoryNotFoundException(
                                                                    "category not found - " + categoryName))));
    }

}
