package com.gila.notification.domain.models;

import com.gila.notification.infrastructure.adapters.inbound.rest.request.UserDto;

import java.util.concurrent.CompletableFuture;

public interface NotificationChannel {
   void send(UserDto user, String message, String category);
}
