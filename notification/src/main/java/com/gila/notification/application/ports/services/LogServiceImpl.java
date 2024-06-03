package com.gila.notification.application.ports.services;


import com.gila.notification.application.ports.LogService;
import com.gila.notification.domain.models.Log;
import com.gila.notification.domain.ports.LogRepository;
import com.gila.notification.infrastructure.adapters.inbound.rest.mapper.LogRestMapper;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.LogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService {


    private final LogRepository logRepository;
    private final LogRestMapper logRestMapper;

    public LogServiceImpl(LogRepository logRepository, LogRestMapper logRestMapper) {

        this.logRepository = logRepository;

        this.logRestMapper = logRestMapper;
    }


    @Override
    public Page<Log> findAllPageable(Pageable pageable) {
        Page<LogEntity> logEntities=  logRepository.findAllPageable(pageable);
        return new PageImpl<>(
                logEntities.stream().map(logRestMapper::toLogResponse).collect(Collectors.toList()),
                pageable,
                logEntities.getTotalElements()
        );
    }


}
