package com.gila.notification.infrastructure.adapters.data;


import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.NotificationEntity;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.ChannelEntity;
import com.gila.notification.domain.models.User;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.CategoryEntity;

import java.util.Arrays;
import java.util.List;

public class MockUsers {

    public static List<NotificationEntity> getUsers() {

        var users = Arrays.asList(
                new User(1L, "Alice", "alice@example.com", "1234567890"),
                new User(2L, "John", "John@example.com", "345345345")

        );

        var categories = Arrays.asList(
                new CategoryEntity("Sports"),
                new CategoryEntity("Movie"));

        var notificationsType = Arrays.asList(
                new ChannelEntity("Sms"),
                new ChannelEntity("Email"),
                new ChannelEntity("Push")

        );


        return Arrays.asList(
                new NotificationEntity(1, categories.get(0), users.get(0), notificationsType.get(0) ),
                new NotificationEntity(2, categories.get(1) , users.get(1), notificationsType.get(1) )

        );

    /* return Arrays.asList(
                new User(1L, "Alice", "alice@example.com", "1234567890"),
                new User(2L, "Bob", "bob@example.com", "0987654321"));
    }*/
    }
}