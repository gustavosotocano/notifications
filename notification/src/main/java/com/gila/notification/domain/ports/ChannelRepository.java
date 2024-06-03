package com.gila.notification.domain.ports;

import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.models.Log;

import java.util.List;


public interface ChannelRepository  {
    List<Channel> findAll();
}
