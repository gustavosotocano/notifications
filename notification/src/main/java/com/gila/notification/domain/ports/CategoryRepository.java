package com.gila.notification.domain.ports;

import com.gila.notification.domain.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository  {
    List<Category> findAll();
    Optional<Category> findById(String categoryName);
}
