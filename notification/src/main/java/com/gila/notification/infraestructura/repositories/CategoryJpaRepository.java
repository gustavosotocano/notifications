package com.gila.notification.infraestructura.repositories;

import com.gila.notification.domain.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, String> {
}