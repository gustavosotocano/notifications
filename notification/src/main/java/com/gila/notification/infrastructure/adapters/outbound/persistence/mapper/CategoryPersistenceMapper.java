package com.gila.notification.infrastructure.adapters.outbound.persistence.mapper;

import com.gila.notification.domain.models.Category;
import com.gila.notification.infrastructure.adapters.inbound.rest.response.CategoryResponse;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryPersistenceMapper {

   // ClientEntity toEntity(Client client);
   CategoryResponse toCategoryResponse(Category category);
   Category toModel(CategoryEntity categoryEntity);
   Category toModelCategory(CategoryEntity categoryEntity);
}
