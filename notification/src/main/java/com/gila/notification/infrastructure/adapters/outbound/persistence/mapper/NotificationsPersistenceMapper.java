package com.gila.notification.infrastructure.adapters.outbound.persistence.mapper;

import com.gila.notification.domain.models.Notifications;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.NotificationEntity;
import org.mapstruct.Mapper;


@Mapper
public interface NotificationsPersistenceMapper {

  Notifications toModel(NotificationEntity notificationEntity);
 //   NotificationEntity toModelEntity(Notifications notifications);
}
