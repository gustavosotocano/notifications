package com.gila.notification.infraestructura.adapters.controllers;

import com.gila.notification.application.ports.CategoryService;
import com.gila.notification.domain.models.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 360000)
public class CategoryController {

    private final CategoryService categoryService;



    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;

    }



    @GetMapping("v1/categories")
    public ResponseEntity<List<Category>> categoryFindAll() {

        return ResponseEntity.ok(categoryService.findAll());
    }
}
