package com.gila.notification.application.port.inbound;

import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.CategoryNotifications;

import java.util.List;
import java.util.Optional;

public interface GetCategoryUseCase {
  Optional<CategoryNotifications> findByCategory(String category);
  List<Category> findByAll();

}
