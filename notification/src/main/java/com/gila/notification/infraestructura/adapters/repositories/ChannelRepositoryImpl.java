package com.gila.notification.infraestructura.adapters.repositories;

import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.models.Log;
import com.gila.notification.domain.ports.ChannelRepository;
import com.gila.notification.domain.ports.LogRepository;
import com.gila.notification.infraestructura.repositories.ChannelJpaRepository;
import com.gila.notification.infraestructura.repositories.LogJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelRepositoryImpl implements ChannelRepository {

    private final ChannelJpaRepository channelJpaRepositoryRepository;

    public ChannelRepositoryImpl(ChannelJpaRepository channelJpaRepositoryRepository) {

        this.channelJpaRepositoryRepository = channelJpaRepositoryRepository;
    }

    @Override
    public List<Channel> findAll() {
        return channelJpaRepositoryRepository.findAll();
    }
}