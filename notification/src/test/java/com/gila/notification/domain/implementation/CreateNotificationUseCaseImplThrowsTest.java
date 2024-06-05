package com.gila.notification.domain.implementation;

import com.gila.notification.application.port.inbound.GetCategoryUseCase;
import com.gila.notification.application.port.outbound.LogsPersistencePort;
import com.gila.notification.domain.exception.CategoryNotFoundException;
import com.gila.notification.domain.implementation.testobjctmapper.MockUsers;
import com.gila.notification.domain.models.CategoryNotifications;
import com.gila.notification.domain.models.Notification;
import com.gila.notification.domain.models.NotificationChannel;
import com.gila.notification.domain.services.Email;
import com.gila.notification.infrastructure.adapters.inbound.rest.request.NotificationRequest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CreateNotificationUseCaseImplThrowsTest {

  private final Map<String, NotificationChannel> notificationChannels=mock(Map.class);


  @Mock
  private GetCategoryUseCase getCategoryUseCase;
  @InjectMocks
  private   CreateNotificationUseCaseImpl createNotificationUseCase;
  @Test
  public void CreateNotificationTestWithThrows() {


      MockitoAnnotations.openMocks(this);
      NotificationRequest notificationRequest = new NotificationRequest("Sports1", "message");
      String exceptionMessage = String.format("Category not found [id]: %s", notificationRequest.getCategory());


      when(getCategoryUseCase.findByCategory(notificationRequest.getCategory()))
              .thenThrow(new CategoryNotFoundException(exceptionMessage));

      // Act & Assert
      assertThrows(CategoryNotFoundException.class, () -> {
        createNotificationUseCase.createNotification(notificationRequest);
      });
    }
}
