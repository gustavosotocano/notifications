package com.gila.notification.domain.models;

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
@Table(name = "notification_type")
public class NotificationType {
    @Id
    @Size(max = 255)
    @Column(name = "name", nullable = false)
    private String name;


    @OneToMany(mappedBy = "notificationsType")
    private List<Notifications> notifications;

    public NotificationType(String name) {
        this.name = name;
    }
}

