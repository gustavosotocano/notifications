package com.gila.notification.infrastructure.adapters.inbound.rest.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class NotificationRequest {

    @NotNull
    private String category;
    @NotNull
    private String message;
}
