package com.gila.notification.infrastructure.adapters.inbound.rest.mapper;

import com.gila.notification.domain.models.Log;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.LogEntity;
import org.mapstruct.Mapper;

@Mapper
public interface LogRestMapper {
 Log toLogResponse(LogEntity log);
}
