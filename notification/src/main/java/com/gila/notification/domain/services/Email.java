package com.gila.notification.domain.services;

import com.gila.notification.domain.models.Log;
import com.gila.notification.domain.models.UserDto;
import com.gila.notification.domain.ports.LogRepository;
import com.gila.notification.domain.ports.NotificationChannel;
import com.gila.notification.infraestructura.repositories.LogJpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service

public class Email implements NotificationChannel {

    private final LogRepository logRepository;

    public Email(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    @Async
    public void send(UserDto user, String message, String category) {
        Log log = new Log( message, category,
                          user.id(), user.name(), user.email(), user.phone(), "Email", new Date());
        logRepository.save(log);
        System.out.println("Email sent "+ user.name());
    }
}