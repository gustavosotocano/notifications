package com.gila.notification.domain.ports;

import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository  {
    List<Category> findAll();
    Optional<Category> findById(String categoryName);
}
