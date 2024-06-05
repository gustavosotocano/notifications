package com.gila.notification.application.port.outbound;

import com.gila.notification.domain.models.NotificationsPageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificationPersistencePort {
      Page<NotificationsPageable> findAllPageable(Pageable pageable);
}
