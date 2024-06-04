package com.gila.notification.application.port.outbound;

import com.gila.notification.domain.models.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LogsPersistencePort {
    Page<Log> findAllPageable(Pageable pageable);
}
