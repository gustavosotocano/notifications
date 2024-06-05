package com.gila.notification.domain.implementation;

import com.gila.notification.application.port.inbound.GetCategoryUseCase;
import com.gila.notification.application.port.outbound.LogsPersistencePort;
import com.gila.notification.domain.implementation.testobjctmapper.MockUsers;
import com.gila.notification.domain.models.CategoryNotifications;
import com.gila.notification.domain.models.Notification;
import com.gila.notification.domain.models.NotificationChannel;
import com.gila.notification.domain.services.Email;
import com.gila.notification.infrastructure.adapters.inbound.rest.request.NotificationRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateNotificationUseCaseImplTest {

  private final Map<String, NotificationChannel> notificationChannels=mock(Map.class);

private final LogsPersistencePort logsPersistencePort=mock(LogsPersistencePort.class);


  @Mock
  private GetCategoryUseCase getCategoryUseCase;

  private final CreateNotificationUseCaseImpl createNotificationUseCase=mock(CreateNotificationUseCaseImpl.class);

  @Test
  public void CreateNotificationTest() {

    // Arrange
    MockitoAnnotations.openMocks(this);
    NotificationRequest notificationRequest = new NotificationRequest("Sports", "message");

    when(getCategoryUseCase.findByCategory(notificationRequest.getCategory()))
            .thenReturn(Optional.of(MockUsers.getCategoryNotifications()));



    Optional<CategoryNotifications> testResponse =
            getCategoryUseCase.findByCategory(notificationRequest.getCategory());

    // Act & Assert
    verify(getCategoryUseCase, times(1))
            .findByCategory(notificationRequest.getCategory() );
    assertEquals("Sports", testResponse.get().getName());

    };

  @Test
  public void CreateNotificationUseCase() {

    // Arrange
    MockitoAnnotations.openMocks(this);
    NotificationRequest notificationRequest = new NotificationRequest("Sports", "message");

    Map<String,NotificationChannel> channelMap=new HashMap<>();
    channelMap.put("email",new Email(logsPersistencePort));

    when(notificationChannels.get("email"))
            .thenReturn(channelMap.get("email"));


    when(getCategoryUseCase.findByCategory(notificationRequest.getCategory()))
            .thenReturn(Optional.of(MockUsers.getCategoryNotifications()));

    Notification expectedNotification =
            new Notification("Sports", "message");

    when(createNotificationUseCase.createNotification(notificationRequest))
            .thenReturn(expectedNotification);

    // Act
    Notification actualNotification =
            createNotificationUseCase.createNotification(notificationRequest);

    // Assert
    verify(createNotificationUseCase, times(1))
           .createNotification(notificationRequest);
    assertEquals(expectedNotification, actualNotification);

  };

}
