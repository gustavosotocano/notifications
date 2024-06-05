package com.gila.notification.application.port.outbound;

import com.gila.notification.domain.models.Log;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.LogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LogsPersistencePort {
    Page<Log> findAllPageable(Pageable pageable);
     void save(Log log);

}
