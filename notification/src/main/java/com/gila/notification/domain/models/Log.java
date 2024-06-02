package com.gila.notification.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Size(max = 50)
    private String category;
    private long userId;
    private String userName;
    private String userEmail;
    @Size(max = 15)
    private String userPhone;
    @Size(max = 50)
    private String channel;
    private Date timestamp;

    public Log(String message, String category, long userId, String userName, String userEmail, String userPhone,
               String channel, Date timestamp) {
        this.timestamp = timestamp;
        this.channel = channel;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userId = userId;
        this.category = category;
        this.message = message;
    }
}
