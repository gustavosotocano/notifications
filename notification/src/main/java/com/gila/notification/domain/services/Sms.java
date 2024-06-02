package com.gila.notification.domain.services;

import com.gila.notification.domain.models.Log;
import com.gila.notification.domain.models.User;
import com.gila.notification.domain.models.UserDto;
import com.gila.notification.domain.ports.LogRepository;
import com.gila.notification.domain.ports.NotificationChannel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Sms implements NotificationChannel {

    private final LogRepository logRepository;

    public Sms(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    @Async
    public void send(UserDto user, String message, String category) {
        Log log = new Log(message, category,
                          user.id(), user.name(), user.email(), user.phone(), "Sms", new Date());
        logRepository.save(log);
        System.out.println("Sms sent "+ user.name());
    }
}