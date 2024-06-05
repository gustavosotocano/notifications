package com.gila.notification.domain.implementation.testobjctmapper;

import com.gila.notification.domain.models.CategoryNotifications;
import com.gila.notification.domain.models.Log;
import com.gila.notification.domain.models.Notification;
import com.gila.notification.infrastructure.adapters.inbound.rest.request.NotificationRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class LogTestObjectMother {
    public static List<Log> aLog() {
        List <Log> logs = new ArrayList<Log>();
       Log log= new Log ("message","Sports",1,"john doe",
                 "jdoe@gmail.com","4569876543","Sms",new Date());
        logs.add(log);
        return logs;


    }

    public static Notification  aNotification(){
        return new Notification ("Soprt","message");
    }
    public static NotificationRequest aNotificationRequest(){
        return new NotificationRequest("Sport","message");
    }

    public static Optional<CategoryNotifications> aCategoryNotifications(){

        return Optional.of(MockUsers.getCategoryNotifications());
    }
}
