package com.gila.notification.domain.models;


import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.NotificationEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class CategoryNotifications {
    private String name;
    private List<NotificationEntity> notifications;
}
