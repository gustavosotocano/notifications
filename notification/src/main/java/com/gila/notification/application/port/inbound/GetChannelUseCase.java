package com.gila.notification.application.port.inbound;

import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.models.ChannelNotifications;

import java.util.List;

public interface GetChannelUseCase {
  List<ChannelNotifications> findByAll();
  List<Channel> findChannels();
}
