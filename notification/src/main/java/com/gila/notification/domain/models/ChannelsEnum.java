package com.gila.notification.domain.models;

import java.util.Arrays;

public enum ChannelsEnum {
    SMS("sms"),
    EMAIL("email"),
    PUSH("push");


    private final String name;

    ChannelsEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static ChannelsEnum fromString(String name) {
       return Arrays.stream(ChannelsEnum.values()).filter(x -> x.getName().equals(name))
                                            .findFirst().orElse(null);
    }
}
