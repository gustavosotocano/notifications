package com.gila.notification.application.port.inbound;

import com.gila.notification.domain.models.NotificationsPageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetNotificationUseCase {
   Page<NotificationsPageable> findAllPageable(Pageable pageable);

}
