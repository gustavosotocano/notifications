package com.gila.notification.infrastructure.adapters.controllers;

import com.gila.notification.application.ports.NotificationService;
import com.gila.notification.domain.ports.LogRepository;
import com.gila.notification.infrastructure.adapters.inbound.rest.request.NotificationDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 360000)
public class NotificationController {

    private final NotificationService notificationService;

    private final LogRepository logRepository;

    public NotificationController(NotificationService notificationService, LogRepository logRepository) {
        this.notificationService = notificationService;
        this.logRepository = logRepository;
    }

    @PostMapping("/v1/send")
    public ResponseEntity<Object> sendNotification(@Valid @RequestBody NotificationDto notificationDto) {
        try {
            notificationService.sendNotifications(notificationDto.getCategory(), notificationDto.getMessage());


            return ResponseEntity.ok(notificationDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/v1/logs")
    public ResponseEntity<Object> logsFindAll(@RequestHeader("GILA-X-PAGE") String page,
                                              @RequestHeader("GILA-X-SIZE") String size) {

        Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
        return ResponseEntity.ok(logRepository.findAllPageable(pageable));
    }
}
