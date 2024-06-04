package com.gila.notification.infrastructure.repositories;

import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.ChannelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelJpaRepository extends JpaRepository<ChannelEntity, String> {

}