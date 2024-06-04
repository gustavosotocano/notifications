package com.gila.notification.infrastructure.adapters.inbound.rest;

import com.gila.notification.application.port.inbound.GetCategoryUseCase;
import com.gila.notification.domain.models.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 360000)
public class CategoryRestAdapter {


    private final GetCategoryUseCase getCategoryUseCase;


    public CategoryRestAdapter(GetCategoryUseCase getCategoryUseCase) {
        this.getCategoryUseCase = getCategoryUseCase;

    }

    @GetMapping("v1/categories")
    public ResponseEntity<List<Category>> categoryFindAll() {
        var categories = getCategoryUseCase.findByAll();

        return ResponseEntity.ok(  categories);
    }
}
