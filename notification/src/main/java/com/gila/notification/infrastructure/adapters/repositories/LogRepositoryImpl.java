package com.gila.notification.infrastructure.adapters.repositories;

import com.gila.notification.domain.models.Log;
import com.gila.notification.domain.ports.LogRepository;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.LogEntity;
import com.gila.notification.infrastructure.adapters.outbound.persistence.mapper.LogPersistenceMapper;
import com.gila.notification.infrastructure.outbound.persistence.repositories.LogJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LogRepositoryImpl implements LogRepository {

    private final LogJpaRepository logJpaRepository;
    private final LogPersistenceMapper logPersistenceMapper;
    public LogRepositoryImpl(LogJpaRepository logJpaRepository, LogPersistenceMapper logPersistenceMapper) {
        this.logJpaRepository = logJpaRepository;
        this.logPersistenceMapper = logPersistenceMapper;
    }

    @Override
    public void save(LogEntity log) {
        logJpaRepository.save(log);
    }

    @Override
    public List<LogEntity> findAll() {
        return logJpaRepository.findAll();
    }

    @Override
    public Page<Log> findAllPageable(Pageable pageable){
        Page<LogEntity> logEntities = logJpaRepository.findAll(pageable);
        return new PageImpl<>(
                logEntities.stream().map(logPersistenceMapper::toModel).collect(Collectors.toList()),
                pageable,
                logEntities.getTotalElements());

    }
}
