package com.gila.notification.application.ports;

import com.gila.notification.domain.models.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LogService {
    Page<Log>  findAllPageable(Pageable pageable);
}