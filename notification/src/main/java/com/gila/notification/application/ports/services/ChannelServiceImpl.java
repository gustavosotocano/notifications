package com.gila.notification.application.ports.services;


import com.gila.notification.application.ports.ChannelService;
import com.gila.notification.application.ports.NotificationService;
import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.models.User;
import com.gila.notification.domain.models.UserDto;
import com.gila.notification.domain.ports.CategoryRepository;
import com.gila.notification.domain.ports.ChannelRepository;
import com.gila.notification.domain.ports.NotificationChannel;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

@Service
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;




    public ChannelServiceImpl(ChannelRepository channelRepository
                              ) {

        this.channelRepository = channelRepository;

    }


    @Override
    public List<Channel> findAll() {
        return channelRepository.findAll();
    }
}