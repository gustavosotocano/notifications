package com.gila.notification.domain.implementation;

import com.gila.notification.application.port.inbound.CreateNotificationUseCase;
import com.gila.notification.application.port.inbound.GetCategoryUseCase;
import com.gila.notification.domain.exception.CategoryNotFoundException;
import com.gila.notification.domain.models.CategoryNotifications;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.ChannelEntity;
import com.gila.notification.domain.models.Notification;
import com.gila.notification.domain.models.User;
import com.gila.notification.domain.models.NotificationChannel;
import com.gila.notification.infrastructure.adapters.inbound.rest.request.UserDto;

import java.util.AbstractMap;
import java.util.Map;


public class CreateNotificationUseCaseImpl implements CreateNotificationUseCase {


    private final GetCategoryUseCase getCategoryUseCase;
    private final Map<String, NotificationChannel> notificationChannels;

    public CreateNotificationUseCaseImpl(GetCategoryUseCase getCategoryUseCase,
                                         Map<String, NotificationChannel> notificationChannels) {

        this.getCategoryUseCase = getCategoryUseCase;
        this.notificationChannels = notificationChannels;
    }

    @Override
    public void createNotification(Notification notification) {
        CategoryNotifications categories = getCategoryUseCase.findByCategory(notification.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException("category not found - " + notification.getCategory()));
        sendChannelNotifications(categories, notification.getMessage());
    }

    public void sendChannelNotifications(CategoryNotifications categories, String message) {
        categories.getNotifications()
                .stream()
                .map(notification -> {
                    ChannelEntity channelEntity = notification.getChannels();
                    NotificationChannel notificationChannel =
                            notificationChannels.get(channelEntity.getName().toLowerCase());
                    return new AbstractMap.SimpleEntry<>(notification, notificationChannel);
                })
                .filter(entry -> entry.getValue() != null)
                .forEach(entry -> sendNotification(entry.getValue(), entry.getKey().getUsers(), message,
                                                   categories.getName()));

    }

    public void sendNotification(NotificationChannel notificationChannel, User user, String message,
                                 String categoryName) {

        UserDto userDto = UserToDto(user);
        notificationChannel.send(userDto, message, categoryName);
    }

    private UserDto UserToDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPhone());
    }

}
