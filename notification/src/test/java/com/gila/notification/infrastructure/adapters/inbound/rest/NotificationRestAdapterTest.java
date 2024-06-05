package com.gila.notification.infrastructure.adapters.inbound.rest;

import com.gila.notification.application.port.inbound.CreateNotificationUseCase;
import com.gila.notification.application.port.inbound.GetNotificationUseCase;
import com.gila.notification.domain.implementation.testobjctmapper.LogTestObjectMother;
import com.gila.notification.domain.models.Notification;
import com.gila.notification.infrastructure.adapters.inbound.rest.mapper.NotificationRestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class NotificationRestAdapterTest {

    private final   CreateNotificationUseCase createNotificationUseCase=mock(CreateNotificationUseCase.class);
    private final GetNotificationUseCase getNotificationUseCase  =mock(GetNotificationUseCase.class);
  //  private final   NotificationRestMapper notificationRestMapper=mock(NotificationRestMapper.class);


    private final NotificationRestAdapter notificationRestAdapter = new NotificationRestAdapter(createNotificationUseCase,
                                                                                                getNotificationUseCase);


    @Test
    public void shouldSendNotificationWhenValidRequest() {
        //GIVEN
        when(createNotificationUseCase.createNotification(
               LogTestObjectMother.aNotificationRequest()))
               .thenReturn(LogTestObjectMother.aNotification());


        //WHEN
        ResponseEntity<Notification> testResponse =
                notificationRestAdapter.sendNotification(  LogTestObjectMother.aNotificationRequest());



        verify(createNotificationUseCase, times(1))
                .createNotification(LogTestObjectMother.aNotificationRequest());
        assertEquals(HttpStatus.CREATED, testResponse.getStatusCode());
        assertNotNull(testResponse.getBody());
        assertEquals(LogTestObjectMother.aNotification(), testResponse.getBody());

    }
}