package com.gila.notification.infraestructura.data;


import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.NotificationType;
import com.gila.notification.domain.models.Notifications;
import com.gila.notification.domain.models.User;

import java.util.Arrays;
import java.util.List;

public class MockUsers {

    public static List<Notifications> getUsers() {

        var users = Arrays.asList(
                new User(1L, "Alice", "alice@example.com", "1234567890"),
                new User(2L, "John", "John@example.com", "345345345")

        );

        var categories = Arrays.asList(
                new Category("Sports"),
                new Category("Movie"));

        var notificationsType = Arrays.asList(
                new NotificationType("Sms"),
                new NotificationType("Email"),
                new NotificationType("Push")

        );


        return Arrays.asList(
                new Notifications(1, categories.get(0), users.get(0), notificationsType.get(0) ),
                new Notifications(2, categories.get(1) , users.get(1), notificationsType.get(1) )

        );

    /* return Arrays.asList(
                new User(1L, "Alice", "alice@example.com", "1234567890"),
                new User(2L, "Bob", "bob@example.com", "0987654321"));
    }*/
    }
}