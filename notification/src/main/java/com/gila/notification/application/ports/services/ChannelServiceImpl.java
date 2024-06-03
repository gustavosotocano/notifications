package com.gila.notification.application.ports.services;


import com.gila.notification.application.ports.ChannelService;
import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.ports.ChannelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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