package com.gila.notification.application.ports;

import com.gila.notification.domain.models.Channel;

import java.util.List;

public interface ChannelService {
    List<Channel> findAll();
}