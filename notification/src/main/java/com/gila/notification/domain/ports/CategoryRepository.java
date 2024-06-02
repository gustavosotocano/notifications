package com.gila.notification.domain.ports;

import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}
