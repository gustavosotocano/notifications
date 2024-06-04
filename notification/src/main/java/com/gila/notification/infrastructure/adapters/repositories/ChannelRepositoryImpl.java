package com.gila.notification.infrastructure.adapters.repositories;

import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.models.ChannelNotifications;
import com.gila.notification.domain.ports.ChannelRepository;
import com.gila.notification.infrastructure.outbound.persistence.mapper.ChannelPersistenceMapper;
import com.gila.notification.infrastructure.repositories.ChannelJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelRepositoryImpl implements ChannelRepository {

    private final ChannelJpaRepository channelJpaRepositoryRepository;
private final ChannelPersistenceMapper channelPersistenceMapper;
    public ChannelRepositoryImpl(ChannelJpaRepository channelJpaRepositoryRepository, ChannelPersistenceMapper channelPersistenceMapper) {

        this.channelJpaRepositoryRepository = channelJpaRepositoryRepository;
        this.channelPersistenceMapper = channelPersistenceMapper;
    }

    @Override
    public List<ChannelNotifications> findAll() {
        return channelJpaRepositoryRepository.findAll().stream()
                .map(channelPersistenceMapper::toModelNotifications)
                .toList();
    }
    @Override
    public List<Channel> findChannels() {
        return channelJpaRepositoryRepository.findAll().stream()
                .map(channelPersistenceMapper::toModel)
                .toList();
    }
}
