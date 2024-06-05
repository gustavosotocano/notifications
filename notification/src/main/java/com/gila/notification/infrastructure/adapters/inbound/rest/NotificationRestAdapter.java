package com.gila.notification.infrastructure.adapters.inbound.rest;

import com.gila.notification.application.port.inbound.CreateNotificationUseCase;
import com.gila.notification.application.port.inbound.GetNotificationUseCase;
import com.gila.notification.domain.exception.HeaderNotFoundException;
import com.gila.notification.domain.models.Notification;
import com.gila.notification.domain.models.NotificationsPageable;
import com.gila.notification.infrastructure.adapters.inbound.rest.request.NotificationRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/notifications")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 360000)
public class NotificationRestAdapter {

    private final CreateNotificationUseCase createNotificationUseCase;
    private final GetNotificationUseCase getNotificationUseCase;


    public NotificationRestAdapter(CreateNotificationUseCase createNotificationUseCase,
                                    GetNotificationUseCase getNotificationUseCase) {
        this.createNotificationUseCase = createNotificationUseCase;


        this.getNotificationUseCase = getNotificationUseCase;
    }

    @PostMapping("/v1/send")
    public ResponseEntity<Notification> sendNotification(@Valid @RequestBody NotificationRequest notificationRequest) {

        Notification notification=  createNotificationUseCase.createNotification(notificationRequest);

        return new ResponseEntity<>(notification, HttpStatus.CREATED);

    }

    @GetMapping("/v1/subscribed")
    public ResponseEntity<Page<NotificationsPageable>> notificationsFindAll(@RequestHeader("GILA-X-PAGE") String page,
                                                                            @RequestHeader("GILA-X-SIZE") String size) {
        if(Objects.isNull(page)) {
            throw new HeaderNotFoundException("005", "Header GILA-X-PAGE is null");
        }
        if(Objects.isNull(size)) {
            throw new HeaderNotFoundException("005","Header GILA-X-SIZE is null");
        }
        Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
        var logs= getNotificationUseCase.findAllPageable(pageable);
        return ResponseEntity.ok(logs);
    }


}
