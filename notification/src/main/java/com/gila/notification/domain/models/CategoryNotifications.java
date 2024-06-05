package com.gila.notification.domain.models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class CategoryNotifications {
    private String name;
    private List<Notifications> notifications;
}
