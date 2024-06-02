package com.gila.notification.application.ports;

public interface NotificationService {
    void sendNotifications(String category, String message);
}