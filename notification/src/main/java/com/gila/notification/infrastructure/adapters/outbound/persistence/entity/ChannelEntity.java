package com.gila.notification.infrastructure.adapters.outbound.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "channels")
public class ChannelEntity {
    @Id
    @Size(max = 50)
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "channels")
    @JsonIgnore
    private List<NotificationEntity> notifications;

    public ChannelEntity(String name) {
        this.name = name;
    }
}
