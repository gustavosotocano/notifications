package com.gila.notification.domain.models;


import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.NotificationEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_gen")
    @SequenceGenerator(name = "users_id_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "users")
    private List<NotificationEntity> notifications  ;

    public User(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
