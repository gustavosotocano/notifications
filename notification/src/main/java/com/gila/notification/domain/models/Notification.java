package com.gila.notification.domain.models;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Notification {

    @NotNull
    private String category;
    @NotNull
    private String message;
}
