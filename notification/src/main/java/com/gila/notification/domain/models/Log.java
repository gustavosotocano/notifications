package com.gila.notification.domain.models;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;



 @Getter
 @Setter
 @AllArgsConstructor
 @NoArgsConstructor
@Entity
@Table(name = "logs")
public class Log {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String category;
    private long userId;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String channel;
    private Date timestamp;

     public Log( String message, String category,long userId, String userName, String userEmail, String userPhone, String channel,  Date timestamp   ) {
         this.timestamp = timestamp;
         this.channel = channel;
         this.userPhone = userPhone;
         this.userEmail = userEmail;
         this.userName = userName;
         this.userId = userId;
         this.category = category;
         this.message = message;
     }

// Getters and setters
}