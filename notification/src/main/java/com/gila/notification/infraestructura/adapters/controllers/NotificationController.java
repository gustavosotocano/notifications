package com.gila.notification.infraestructura.adapters.controllers;

import com.gila.notification.application.ports.NotificationService;
import com.gila.notification.domain.ports.LogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    private final LogRepository logRepository;

    public NotificationController(NotificationService notificationService, LogRepository logRepository) {
        this.notificationService = notificationService;
        this.logRepository = logRepository;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestParam String category, @RequestParam String message) {
        try {
            notificationService.sendNotifications(category, message);
            return ResponseEntity.ok("Notifications sent");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/logs")
    public ResponseEntity<Object> logsFindAll() {
        return ResponseEntity.ok(logRepository.findAll());
    }
}
