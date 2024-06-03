package com.gila.notification.infraestructura.adapters.controllers;

import com.gila.notification.application.ports.ChannelService;
import com.gila.notification.application.ports.NotificationService;
import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.ports.LogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 360000)
public class ChannelController {

    private final ChannelService channelService;



    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;

    }



    @GetMapping("v1/channels")
    public ResponseEntity<List<Channel>> logsFindAll() {
        return ResponseEntity.ok(channelService.findAll());
    }
}