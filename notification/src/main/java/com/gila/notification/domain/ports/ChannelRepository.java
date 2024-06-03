package com.gila.notification.domain.ports;

import com.gila.notification.domain.models.Channel;

import java.util.List;


public interface ChannelRepository  {
    List<Channel> findAll();
}
