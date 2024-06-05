package com.gila.notification.infrastructure.adapters.outbound.persistence.mapper;

import com.gila.notification.domain.models.Log;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.LogEntity;
import org.mapstruct.Mapper;


@Mapper
public interface LogPersistenceMapper {

    Log toModel(LogEntity logEntity);
    LogEntity toModelEntity(Log log);
}
