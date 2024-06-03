package com.gila.notification.infraestructura.adapters.model;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NotificationDto {

    @NotNull
    private String category;
    @NotNull
    private String message;
}
