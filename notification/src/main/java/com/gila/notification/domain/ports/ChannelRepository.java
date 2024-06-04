package com.gila.notification.domain.ports;

import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.models.ChannelNotifications;

import java.util.List;


public interface ChannelRepository  {
    List<ChannelNotifications> findAll();
    List<Channel> findChannels();
}
