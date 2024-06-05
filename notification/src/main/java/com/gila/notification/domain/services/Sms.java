package com.gila.notification.domain.services;

import com.gila.notification.application.port.outbound.LogsPersistencePort;
import com.gila.notification.domain.models.Log;
import com.gila.notification.infrastructure.adapters.inbound.rest.request.UserDto;
import com.gila.notification.domain.models.NotificationChannel;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Service
public class Sms implements NotificationChannel {

    public static final String NOTIFICATION_TYPE_SMS="Sms";
    private final LogsPersistencePort logsPersistencePort;

    public Sms( LogsPersistencePort logsPersistencePort) {
        this.logsPersistencePort = logsPersistencePort;

    }

    @Override
    @Async
    public void send(UserDto user, String message, String category) {
        Log log = new Log(message, category,
                                      user.id(), user.name(), user.email(), user.phone(), NOTIFICATION_TYPE_SMS, new Date());
        logsPersistencePort.save(log);


    }
}