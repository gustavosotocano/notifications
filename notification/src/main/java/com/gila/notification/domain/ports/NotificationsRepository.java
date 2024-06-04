package com.gila.notification.domain.ports;


import com.gila.notification.domain.models.CategoryNotifications;

import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationsRepository extends JpaRepository<NotificationEntity, Integer> {
    List<NotificationEntity> getNotificationsByCategoriesName(CategoryNotifications category);
}