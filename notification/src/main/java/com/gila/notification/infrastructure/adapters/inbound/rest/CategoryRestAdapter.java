package com.gila.notification.infrastructure.adapters.inbound.rest;

import com.gila.notification.application.ports.CategoryService;
import com.gila.notification.infrastructure.adapters.inbound.rest.mapper.CategoryRestMapper;
import com.gila.notification.infrastructure.adapters.inbound.rest.response.CategoryResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 360000)
public class CategoryRestAdapter {

    private final CategoryService categoryService;
    private final CategoryRestMapper categoryRestMapper = Mappers.getMapper(CategoryRestMapper.class);

    public CategoryRestAdapter(CategoryService categoryService) {
        this.categoryService = categoryService;

    }

    @GetMapping("v1/categories")
    public ResponseEntity<List<CategoryResponse>> categoryFindAll() {
        var categories = categoryService.findAll();
        var categoriesResponse=categories.stream()
                .map(categoryRestMapper::toCategoryResponse)
                .toList();
        return ResponseEntity.ok(  categoriesResponse);
    }
}
