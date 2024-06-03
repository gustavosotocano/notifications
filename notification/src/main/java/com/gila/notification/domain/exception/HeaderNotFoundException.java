package com.gila.notification.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class HeaderNotFoundException extends RuntimeException {
    public String code;
    public String message;

    public HeaderNotFoundException(String code, String message) {
        super();
        this.message = message;
        this.code = code;
    }

}
