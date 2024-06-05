package com.gila.notification.domain.implementation;

import com.gila.notification.domain.exception.CategoryNotFoundException;
import com.gila.notification.domain.implementation.GetCategoryUseCaseImpl;
import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.CategoryNotifications;
import com.gila.notification.application.port.outbound.CategoryPersistencePort;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetCategoryUseCaseImplTest {

    @Test
    void testFindByCategoryMethod_whenCategoryIsPresent() {
        // Arrange
        CategoryPersistencePort mockPort = mock(CategoryPersistencePort.class);
        String category = "TestCategory";
        CategoryNotifications notifications = new CategoryNotifications();
        when(mockPort.getCategoryById(category)).thenReturn(Optional.of(notifications));

        GetCategoryUseCaseImpl useCase = new GetCategoryUseCaseImpl(mockPort);
       
        // Act
        Optional<CategoryNotifications> result = useCase.findByCategory(category);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(notifications, result.get());
    }

    @Test
    void testFindByCategoryMethod_whenCategoryIsNotPresent() {
        // Arrange
        CategoryPersistencePort mockPort = mock(CategoryPersistencePort.class);
        String category = "TestCategory";
        when(mockPort.getCategoryById(category)).thenReturn(Optional.empty());

        GetCategoryUseCaseImpl useCase = new GetCategoryUseCaseImpl(mockPort);

        // Act and Assert
        assertThrows(CategoryNotFoundException.class, () -> {
            Optional<CategoryNotifications> result = useCase.findByCategory(category);
        });
    }
}