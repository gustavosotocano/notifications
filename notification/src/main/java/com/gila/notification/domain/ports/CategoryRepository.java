package com.gila.notification.domain.ports;
import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.CategoryNotifications;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository  {
    List<Category> findAll();
    Optional<CategoryNotifications>  findById(String categoryName);
}
