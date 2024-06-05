package com.gila.notification.infrastructure.adapters.outbound.persistence;

import com.gila.notification.application.port.outbound.NotificationPersistencePort;
import com.gila.notification.domain.models.NotificationsPageable;
import com.gila.notification.domain.ports.NotificationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class NotificationsPersistenceAdapter implements NotificationPersistencePort {

    private final NotificationsRepository notificationsRepository;

    @Override
   public Page<NotificationsPageable> findAllPageable(Pageable pageable){

        return notificationsRepository.findAllPageable(pageable);

    }

}
