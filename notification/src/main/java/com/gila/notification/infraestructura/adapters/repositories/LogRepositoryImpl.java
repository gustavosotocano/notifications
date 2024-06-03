package com.gila.notification.infraestructura.adapters.repositories;

import com.gila.notification.domain.models.Log;
import com.gila.notification.domain.ports.LogRepository;
import com.gila.notification.infraestructura.repositories.LogJpaRepository;
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
    public void save(Log log) {
        logJpaRepository.save(log);
    }

    @Override
    public List<Log> findAll() {
        return logJpaRepository.findAll();
    }

    @Override
    public Page<Log> findAllPageable(  Pageable pageable){
        return logJpaRepository.findAll( pageable) ;
    }
}
