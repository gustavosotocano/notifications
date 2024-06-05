package com.gila.notification.infrastructure.outbound.persistence.repositories;

import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.NotificationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsJpaRepository extends JpaRepository<NotificationEntity, Integer> {
     Page<NotificationEntity> findAll(Pageable pageable);
}