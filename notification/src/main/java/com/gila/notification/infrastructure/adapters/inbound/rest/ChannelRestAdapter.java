package com.gila.notification.infrastructure.adapters.inbound.rest;

import com.gila.notification.application.ports.ChannelService;
import com.gila.notification.domain.models.Channel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 360000)
public class ChannelRestAdapter {

    private final ChannelService channelService;



    public ChannelRestAdapter(ChannelService channelService) {
        this.channelService = channelService;

    }



    @GetMapping("v1/channels")
    public ResponseEntity<List<Channel>> logsFindAll() {
        return ResponseEntity.ok(channelService.findAll());
    }
}