package com.gila.notification.domain.implementation;

import com.gila.notification.application.port.inbound.GetLogsUseCase;
import com.gila.notification.application.port.outbound.LogsPersistencePort;
import com.gila.notification.domain.models.Log;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@AllArgsConstructor
public class GetLogUseCaseImpl implements GetLogsUseCase {

    private final LogsPersistencePort logsPersistencePort;




    @Override
    public Page<Log> findAllPageable(Pageable pageable) {

        return logsPersistencePort.findAllPageable( pageable );
    }

}
