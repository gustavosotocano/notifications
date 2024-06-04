package com.gila.notification.infrastructure.outbound.persistence;

import com.gila.notification.application.port.outbound.LogsPersistencePort;
import com.gila.notification.domain.models.Log;
import com.gila.notification.domain.ports.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class LogsPersistenceAdapter implements LogsPersistencePort {

    private final LogRepository logRepository;

    @Override
   public Page<Log> findAllPageable(Pageable pageable){

        return logRepository.findAllPageable(pageable);

    }
}
