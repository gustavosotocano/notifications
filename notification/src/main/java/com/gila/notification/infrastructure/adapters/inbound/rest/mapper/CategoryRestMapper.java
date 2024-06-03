package com.gila.notification.infrastructure.adapters.inbound.rest.mapper;

import com.gila.notification.domain.models.Category;

import com.gila.notification.infrastructure.adapters.inbound.rest.response.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryRestMapper {
 CategoryResponse toCategoryResponse(Category category);
}
