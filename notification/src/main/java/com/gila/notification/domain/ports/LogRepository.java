package com.gila.notification.domain.ports;

import com.gila.notification.domain.models.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LogRepository {
    void save(Log log);
    List<Log> findAll();
   Page<Log> findAllPageable(  Pageable pageable);
}
