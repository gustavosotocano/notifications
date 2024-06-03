package com.gila.notification.infrastructure.adapters.outbound.persistence.mapper;

import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.CategoryNotifications;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryPersistenceMapper {

    Category toModel(CategoryEntity categoryEntity);

    CategoryNotifications toModelCategoryNotifications(CategoryEntity categoryEntity);
}
