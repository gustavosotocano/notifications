package com.gila.notification.application.ports.services;


import com.gila.notification.application.ports.NotificationService;
import com.gila.notification.domain.models.*;
import com.gila.notification.domain.ports.CategoryRepository;
import com.gila.notification.domain.ports.NotificationChannel;
import com.gila.notification.domain.ports.NotificationsRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationsRepository notificationsRepository;
    private final CategoryRepository categoryRepository;


    private final Map<String, NotificationChannel> notificationChannels;

    public NotificationServiceImpl(NotificationsRepository notificationsRepository, CategoryRepository categoryRepository, Map<String, NotificationChannel> notificationChannels) {
        this.notificationsRepository = notificationsRepository;
        this.categoryRepository = categoryRepository;
        this.notificationChannels = notificationChannels;
    }

    /*
        @Override
        public void sendNotifications(String category, String message) {
            List<User> users = userRepository.getUsers();
            for (User user : users) {
                if (user.getSubscribed().contains(category)) {
                    for (String channel : user.getChannels().split(",")) {
                        NotificationChannel notificationChannel = notificationChannels.get(channel.toLowerCase());
                        if (notificationChannel != null) {
                            notificationChannel.send(user, message, category);
                        }
                    }
                }
            }
        }*/
    @Override
    public void sendNotifications(String category, String message) {
        //List<User> users = userRepository.getUsers();
        Category categories = categoryRepository.findById(category)
                .orElseThrow(() -> new CategoryNotFoundException("category not found - " + category));
    //    List<Notifications> notifications = notificationsRepository.getNotificationsByCategoriesName(categories);
        processUserNotifications(categories,  message);
    }

    private void processUserNotifications(Category category,  String message) {


        sendChannelNotifications(  category, message);

    }


    public void sendChannelNotifications(Category categories , String message) {
/*
        for (Notifications notification :categories.getNotifications()) {

            NotificationType notificationType=notification.getNotificationsType();
            NotificationChannel notificationChannel = notificationChannels.get(notificationType.getName().toLowerCase());
            if (notificationChannel != null) {
                notificationChannel.send(notification.getUsers(),  message , categories.getName());
            }
        }
*/
        categories.getNotifications()
               //.parallelStream()

                .stream()

               // .parallel()
                .map(notification -> {
                    NotificationType notificationType = notification.getNotificationsType();
                    NotificationChannel notificationChannel = notificationChannels.get(notificationType.getName().toLowerCase());
                    return new AbstractMap.SimpleEntry<>(notification, notificationChannel);
                })
                .filter(entry -> entry.getValue() != null)
                .forEach(entry -> sendNotification(entry.getValue(), entry.getKey().getUsers(), message, categories.getName()));

    }



    public void sendNotification(NotificationChannel notificationChannel, User user, String message, String categoryName) {

      UserDto userDto=UserToDto(user);
        notificationChannel.send(userDto, message, categoryName);
    }


    private UserDto UserToDto(User user) {
        UserDto userDto = new UserDto(user.getId(),user.getName(),user.getEmail(),user.getPhone());


        return userDto;
    }


}