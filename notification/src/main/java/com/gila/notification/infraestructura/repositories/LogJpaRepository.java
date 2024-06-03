package com.gila.notification.infraestructura.repositories;

import com.gila.notification.domain.models.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogJpaRepository extends JpaRepository<Log, Long> {

     Page<Log> findAll(Pageable pageable);
}