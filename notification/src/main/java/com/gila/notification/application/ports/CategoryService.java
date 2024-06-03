package com.gila.notification.application.ports;

import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.Channel;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}