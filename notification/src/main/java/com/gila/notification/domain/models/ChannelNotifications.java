package com.gila.notification.domain.models;

import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.NotificationEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ChannelNotifications {

    private String name;


    private List<NotificationEntity> notifications;


}
