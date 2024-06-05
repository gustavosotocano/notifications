package com.gila.notification.application.port.inbound;

import com.gila.notification.domain.models.Notification;
import com.gila.notification.infrastructure.adapters.inbound.rest.request.NotificationRequest;


public interface CreateNotificationUseCase {
     Notification createNotification(NotificationRequest notificationRequest);
}
