package com.gila.notification.application.port.inbound;

import com.gila.notification.domain.models.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetLogsUseCase {

    Page<Log> findAllPageable(Pageable pageable);
}
