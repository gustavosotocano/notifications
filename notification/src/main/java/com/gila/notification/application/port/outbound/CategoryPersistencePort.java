package com.gila.notification.application.port.outbound;


import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.CategoryNotifications;

import java.util.List;
import java.util.Optional;

public interface CategoryPersistencePort {

    Optional<CategoryNotifications> getCategoryById(String category);
    List<Category> getClientByAll();
}
