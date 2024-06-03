package com.gila.notification.infraestructura.repositories;

import com.gila.notification.domain.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelJpaRepository extends JpaRepository<Channel, String> {
}