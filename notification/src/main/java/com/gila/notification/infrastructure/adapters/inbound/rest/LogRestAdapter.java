package com.gila.notification.infrastructure.adapters.inbound.rest;

import com.gila.notification.application.ports.LogService;
import com.gila.notification.domain.exception.HeaderNotFoundException;
import com.gila.notification.domain.models.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
@RestController
@RequestMapping("/notifications")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 360000)
public class LogRestAdapter {

    private final LogService logService;

    public LogRestAdapter(LogService logService) {
        this.logService = logService;
    }


    @GetMapping("/v1/logs")
    public ResponseEntity<Page<Log>> logsFindAll(@RequestHeader("GILA-X-PAGE") String page,
                                                 @RequestHeader("GILA-X-SIZE") String size) {
        if(Objects.isNull(page)) {
            throw new HeaderNotFoundException("005", "Header GILA-X-PAGE is null");
        }
        if(Objects.isNull(size)) {
            throw new HeaderNotFoundException("005","Header GILA-X-SIZE is null");
        }
        Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
        var logs= logService.findAllPageable(pageable);
        return ResponseEntity.ok(logs);
    }
}
