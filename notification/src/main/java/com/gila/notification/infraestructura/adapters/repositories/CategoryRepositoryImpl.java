package com.gila.notification.infraestructura.adapters.repositories;

import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.ports.CategoryRepository;
import com.gila.notification.domain.ports.ChannelRepository;
import com.gila.notification.infraestructura.repositories.CategoryJpaRepository;
import com.gila.notification.infraestructura.repositories.ChannelJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepositoryRepository;

    public CategoryRepositoryImpl( CategoryJpaRepository categoryJpaRepositoryRepository) {
        this.categoryJpaRepositoryRepository = categoryJpaRepositoryRepository;


    }

    @Override
    public List<Category> findAll() {
        return categoryJpaRepositoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(String categoryName) {
        return categoryJpaRepositoryRepository.findById(categoryName);
    }

}
