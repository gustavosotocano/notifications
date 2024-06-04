package com.gila.notification.domain.services;

import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.LogEntity;
import com.gila.notification.infrastructure.adapters.inbound.rest.request.UserDto;
import com.gila.notification.domain.ports.LogRepository;
import com.gila.notification.domain.models.NotificationChannel;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service

public class Push implements NotificationChannel {

    public static final String NOTIFICATION_TYPE_PUSH = "Push";
    private final LogRepository logRepository;

    public Push(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    @Async
    public void send(UserDto user, String message, String category) {
        LogEntity log = new LogEntity(System.nanoTime(), message, category,
                                      user.id(), user.name(), user.email(), user.phone(), NOTIFICATION_TYPE_PUSH, new Date());
        logRepository.save(log);
        System.out.println("Push sent " + user.name());
    }
}
