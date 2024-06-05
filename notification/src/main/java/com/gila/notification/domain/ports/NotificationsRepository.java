package com.gila.notification.domain.ports;


import com.gila.notification.domain.models.NotificationsPageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepository{
    Page<NotificationsPageable> findAllPageable(Pageable pageable);
}