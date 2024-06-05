package com.gila.notification.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data

public class Log {
    private Long id;
    private String message;

    private String category;
    private long userId;
    private String userName;
    private String userEmail;

    private String userPhone;

    private String channel;
    private Date timestamp;

    public Log(String message, String category, long userId, String userName, String userEmail, String userPhone, String channel, Date timestamp) {
        this.message = message;
        this.category = category;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.channel = channel;
        this.timestamp = timestamp;
    }
}
