package com.gila.notification.application.port.outbound;


import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.models.ChannelNotifications;

import java.util.List;

public interface ChannelPersistencePort {
      List<ChannelNotifications> findByAll();
      List<Channel> findChannels();
}
