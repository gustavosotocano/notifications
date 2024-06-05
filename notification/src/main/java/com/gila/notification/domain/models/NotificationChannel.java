package com.gila.notification.domain.models;

import com.gila.notification.infrastructure.adapters.inbound.rest.request.UserDto;

public interface NotificationChannel {
   void send(UserDto user, String message, String category);
}
