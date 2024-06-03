package com.gila.notification.domain.models;



import lombok.AllArgsConstructor;


import java.util.Date;

@AllArgsConstructor
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


}
