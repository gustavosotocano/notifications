package com.gila.notification.domain.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NotificationsPageable {
    private Integer id;
    private String categoriesName;
    private String users;
    private String channels;
}
