package com.gila.notification.domain.models;


import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.CategoryEntity;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.ChannelEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Notifications {
    private Integer id;
    private CategoryEntity categoriesName;
    private User users;
    private ChannelEntity channels;
}
