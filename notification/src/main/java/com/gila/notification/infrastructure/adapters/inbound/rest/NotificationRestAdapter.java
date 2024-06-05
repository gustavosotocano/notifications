package com.gila.notification.infrastructure.adapters.inbound.rest;

import com.gila.notification.application.port.inbound.CreateNotificationUseCase;
import com.gila.notification.domain.models.Notification;
import com.gila.notification.infrastructure.adapters.inbound.rest.mapper.NotificationRestMapper;
import com.gila.notification.infrastructure.adapters.inbound.rest.request.NotificationRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 360000)
public class NotificationRestAdapter {

    private final CreateNotificationUseCase createNotificationUseCase;


    public NotificationRestAdapter(CreateNotificationUseCase createNotificationUseCase,
                                   NotificationRestMapper notificationRestMapper) {
        this.createNotificationUseCase = createNotificationUseCase;


    }

    @PostMapping("/v1/send")
    public ResponseEntity<Notification> sendNotification(@Valid @RequestBody NotificationRequest notificationRequest) {

        Notification notification=  createNotificationUseCase.createNotification(notificationRequest);

        return new ResponseEntity<>(notification, HttpStatus.CREATED);

    }
}
