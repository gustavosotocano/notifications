package com.gila.notification.application.ports.services;


import com.gila.notification.application.ports.NotificationService;
import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.models.User;
import com.gila.notification.domain.models.UserDto;
import com.gila.notification.domain.ports.CategoryRepository;
import com.gila.notification.domain.ports.NotificationChannel;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Map;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final CategoryRepository categoryRepository;


    private final Map<String, NotificationChannel> notificationChannels;

    public NotificationServiceImpl(CategoryRepository categoryRepository,
                                   Map<String, NotificationChannel> notificationChannels) {

        this.categoryRepository = categoryRepository;
        this.notificationChannels = notificationChannels;
    }

    @Override
    public void sendNotifications(String category, String message) {
        Category categories = categoryRepository.findById(category)
                .orElseThrow(() -> new CategoryNotFoundException("category not found - " + category));
        processUserNotifications(categories, message);
    }

    private void processUserNotifications(Category category, String message) {
        sendChannelNotifications(category, message);
    }


    public void sendChannelNotifications(Category categories, String message) {
        categories.getNotifications()
                .stream()
                .map(notification -> {
                    Channel channel = notification.getChannels();
                    NotificationChannel notificationChannel =
                            notificationChannels.get(channel.getName().toLowerCase());
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