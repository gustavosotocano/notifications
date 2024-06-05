package com.gila.notification.infrastructure.adapters.outbound.persistence;

import com.gila.notification.domain.models.CategoryNotifications;
import com.gila.notification.domain.ports.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class CategoryPersistenceAdapterTest {

    @Test
    void getCategoryById_validCategory_returnsCategoryNotifications() {
        // Arrange
        CategoryRepository mockRepo = mock(CategoryRepository.class);
        CategoryPersistenceAdapter adapterUnderTest = new CategoryPersistenceAdapter(mockRepo);
        String mockCategoryId = "mockCategory";
        CategoryNotifications expected = new CategoryNotifications();
        when(mockRepo.findByCategory(mockCategoryId)).thenReturn(Optional.of(expected));
        
        // Act
        Optional<CategoryNotifications> result = adapterUnderTest.getCategoryById(mockCategoryId);

        // Assert
        verify(mockRepo, times(1)).findByCategory(mockCategoryId);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(expected, result.get());
    }

    @Test
    void getCategoryById_invalidCategory_returnsOptionalEmpty() {
        // Arrange
        CategoryRepository mockRepo = mock(CategoryRepository.class);
        CategoryPersistenceAdapter adapterUnderTest = new CategoryPersistenceAdapter(mockRepo);
        String mockCategoryId = "nonexistent";
        when(mockRepo.findByCategory(mockCategoryId)).thenReturn(Optional.empty());

        // Act
        Optional<CategoryNotifications> result = adapterUnderTest.getCategoryById(mockCategoryId);

        // Assert
        verify(mockRepo, times(1)).findByCategory(mockCategoryId);
        Assertions.assertTrue(result.isEmpty());
    }
}