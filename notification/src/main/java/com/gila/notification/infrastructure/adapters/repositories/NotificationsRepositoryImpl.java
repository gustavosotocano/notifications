package com.gila.notification.infrastructure.adapters.repositories;

import com.gila.notification.domain.models.NotificationsPageable;
import com.gila.notification.domain.ports.NotificationsRepository;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.NotificationEntity;
import com.gila.notification.infrastructure.adapters.outbound.persistence.mapper.NotificationsPersistenceMapper;
import com.gila.notification.infrastructure.outbound.persistence.repositories.NotificationsJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Repository
public class NotificationsRepositoryImpl implements NotificationsRepository {

    private final NotificationsJpaRepository  notificationsJpaRepository;
    private final NotificationsPersistenceMapper notificationsPersistenceMapper;
    public NotificationsRepositoryImpl(NotificationsJpaRepository notificationsJpaRepository, NotificationsPersistenceMapper notificationsPersistenceMapper) {
        this.notificationsJpaRepository = notificationsJpaRepository;

        this.notificationsPersistenceMapper = notificationsPersistenceMapper;

    }



    @Override
    public Page<NotificationsPageable> findAllPageable(Pageable pageable){
        Page<NotificationEntity> notificationEntities = notificationsJpaRepository.findAll(pageable);
        return new PageImpl<>(
                notificationEntities.stream().map(this::toModel).collect(Collectors.toList()),
                pageable,
                notificationEntities.getTotalElements());

    }

    private NotificationsPageable toModel(NotificationEntity notificationEntity){
        return new NotificationsPageable(
                notificationEntity.getId(),
                notificationEntity.getUsers().getName(),
                notificationEntity.getCategoriesName().getName(),
                notificationEntity.getChannels().getName()
        );
    }
}
