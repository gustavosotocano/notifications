package com.gila.notification.domain.models;

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
@Table(name = "categories")
public class Category {
    @Id
    @Size(max = 50)
    @Column(name = "name", nullable = false)

    private String name;

    @OneToMany(mappedBy = "categoriesName")
    @JsonIgnore
    private  List<Notifications> notifications;

    public Category(String name) {
        this.name = name;
    }
}
