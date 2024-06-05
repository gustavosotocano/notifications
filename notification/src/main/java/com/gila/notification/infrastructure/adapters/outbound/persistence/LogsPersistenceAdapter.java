package com.gila.notification.infrastructure.adapters.outbound.persistence;

import com.gila.notification.application.port.outbound.LogsPersistencePort;
import com.gila.notification.domain.models.Log;
import com.gila.notification.domain.ports.LogRepository;
import com.gila.notification.infrastructure.adapters.outbound.persistence.mapper.LogPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class LogsPersistenceAdapter implements LogsPersistencePort {

    private final LogRepository logRepository;
   private final LogPersistenceMapper logPersistenceMapper;
    @Override
   public Page<Log> findAllPageable(Pageable pageable){

        return logRepository.findAllPageable(pageable);

    }

    @Override
    public void save(Log log) {
         logRepository.save(logPersistenceMapper.toModelEntity(log));

    }
}
