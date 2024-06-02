package com.gila.notification.domain.ports;

import com.gila.notification.domain.models.Log;

import java.util.List;

public interface LogRepository {
    void save(Log log);
    List<Log> findAll();
}