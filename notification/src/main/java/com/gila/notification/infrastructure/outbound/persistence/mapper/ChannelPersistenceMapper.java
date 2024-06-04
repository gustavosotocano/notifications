package com.gila.notification.infrastructure.outbound.persistence.mapper;

import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.models.ChannelNotifications;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.ChannelEntity;
import org.mapstruct.Mapper;



@Mapper
public interface ChannelPersistenceMapper {


    ChannelNotifications toModelNotifications(ChannelEntity channelEntity);
    Channel toModel(ChannelEntity  channel);
}
