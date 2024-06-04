package com.gila.notification.infrastructure.adapters.inbound.rest.mapper;

import com.gila.notification.domain.models.Notification;
import com.gila.notification.infrastructure.adapters.inbound.rest.request.NotificationRequest;
import org.mapstruct.Mapper;

@Mapper
public interface NotificationRestMapper {
 Notification toModel(NotificationRequest notificationRequest);
}
