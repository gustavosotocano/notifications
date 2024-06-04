package com.gila.notification.domain.ports;

import com.gila.notification.domain.models.Log;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.LogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LogRepository {
    void save(LogEntity log);

    List<LogEntity> findAll();

    Page<Log> findAllPageable(Pageable pageable);
}
