package com.gila.notification.infrastructure.adapters.repositories;

import com.gila.notification.domain.ports.LogRepository;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.LogEntity;
import com.gila.notification.infrastructure.repositories.LogJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogRepositoryImpl implements LogRepository {

    private final LogJpaRepository logJpaRepository;

    public LogRepositoryImpl(LogJpaRepository logJpaRepository) {
        this.logJpaRepository = logJpaRepository;
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
    public Page<LogEntity> findAllPageable(Pageable pageable){

        return logJpaRepository.findAll( pageable) ;
    }
}
