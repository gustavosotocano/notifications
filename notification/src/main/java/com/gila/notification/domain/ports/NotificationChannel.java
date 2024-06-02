package com.gila.notification.domain.ports;


import com.gila.notification.domain.models.UserDto;

public interface NotificationChannel {
    void send(UserDto user, String message, String category);
}