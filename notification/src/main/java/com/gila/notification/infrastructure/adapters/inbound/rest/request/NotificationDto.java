package com.gila.notification.infrastructure.adapters.inbound.rest.request;


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
