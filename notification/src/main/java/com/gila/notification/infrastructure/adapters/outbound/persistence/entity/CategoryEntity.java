package com.gila.notification.infrastructure.adapters.outbound.persistence.entity;

import com.gila.notification.domain.models.Notifications;
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
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @Size(max = 50)
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "categoriesName")
    private  List<Notifications> notifications;

    public CategoryEntity(String name) {
        this.name = name;
    }
}
