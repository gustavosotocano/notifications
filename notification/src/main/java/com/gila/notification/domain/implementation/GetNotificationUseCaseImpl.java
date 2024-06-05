package com.gila.notification.domain.implementation;

import com.gila.notification.application.port.inbound.GetNotificationUseCase;
import com.gila.notification.application.port.outbound.NotificationPersistencePort;
import com.gila.notification.domain.models.NotificationsPageable;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@AllArgsConstructor
public class GetNotificationUseCaseImpl implements GetNotificationUseCase {

    private final NotificationPersistencePort notificationPersistencePort;

    @Override
    public Page<NotificationsPageable> findAllPageable(Pageable pageable) {

        return notificationPersistencePort.findAllPageable(pageable);
    }

}
