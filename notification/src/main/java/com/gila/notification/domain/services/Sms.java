package com.gila.notification.domain.services;

import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.LogEntity;
import com.gila.notification.domain.models.UserDto;
import com.gila.notification.domain.ports.LogRepository;
import com.gila.notification.domain.ports.NotificationChannel;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Sms implements NotificationChannel {

    public static final String NOTIFICATION_TYPE_SMS="Sms";
    private final LogRepository logRepository;

    public Sms(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    @Async
    public void send(UserDto user, String message, String category) {
        LogEntity log = new LogEntity(message, category,
                                      user.id(), user.name(), user.email(), user.phone(), NOTIFICATION_TYPE_SMS, new Date());
        logRepository.save(log);
        System.out.println("Sms sent "+ user.name());
    }
}