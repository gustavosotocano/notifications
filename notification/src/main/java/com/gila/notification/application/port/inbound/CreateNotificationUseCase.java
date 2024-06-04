package com.gila.notification.application.port.inbound;

import com.gila.notification.domain.models.Notification;
 

public interface CreateNotificationUseCase {
    void createNotification(Notification notification);
}
