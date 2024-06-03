package com.gila.notification.infrastructure.adapters.inbound.rest;

import com.gila.notification.application.ports.NotificationService;
import com.gila.notification.infrastructure.adapters.inbound.rest.request.NotificationRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 360000)
public class NotificationRestAdapter {

    private final NotificationService notificationService;

    public NotificationRestAdapter(NotificationService notificationService) {
        this.notificationService = notificationService;

    }

    @PostMapping("/v1/send")
    public ResponseEntity<Object> sendNotification(@Valid @RequestBody NotificationRequest notificationRequest) {
        try {
            notificationService.sendNotifications(notificationRequest.getCategory(), notificationRequest.getMessage());
            return ResponseEntity.ok(notificationRequest);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
