package com.gila.notification.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Log {

    private String message;

    private String category;
    private long userId;
    private String userName;
    private String userEmail;

    private String userPhone;

    private String channel;
    private Date timestamp;

}
