package com.gila.notification.infrastructure.outbound.persistence.repositories;

import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.LogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LogJpaRepository extends JpaRepository<LogEntity, Long> {
     @Query("SELECT  a from LogEntity a order by a.timestamp desc"  )
     Page<LogEntity> findAll(Pageable pageable);
}