package com.gila.notification.infrastructure.outbound.persistence.repositories;

import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, String> {
}