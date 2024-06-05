package com.gila.notification.infrastructure.adapters.repositories;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gila.notification.domain.exception.CategoryNotFoundException;
import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.CategoryNotifications;
import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.CategoryEntity;
import com.gila.notification.infrastructure.adapters.outbound.persistence.mapper.CategoryNotificationsPersistenceMapper;
import com.gila.notification.infrastructure.adapters.outbound.persistence.mapper.CategoryPersistenceMapper;
import com.gila.notification.infrastructure.outbound.persistence.repositories.CategoryJpaRepository;
import com.gila.notification.infrastructure.adapters.repositories.CategoryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class CategoryRepositoryImplTest {

    @Mock
    private CategoryJpaRepository categoryJpaRepository;

    @Mock
    private CategoryNotificationsPersistenceMapper categoryNotificationsPersistenceMapper;

    @Mock
    private CategoryPersistenceMapper categoryPersistenceMapper;

    private CategoryRepositoryImpl categoryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryRepository = new CategoryRepositoryImpl(categoryJpaRepository, categoryNotificationsPersistenceMapper, categoryPersistenceMapper);
    }

    @Test
    public void findByCategory_WhenCategoryExists_ShouldReturnCategoryNotifications() {
        // Arrange
        String existentCategory = "Technology";
        CategoryEntity categoryInstance =   mock(CategoryEntity.class);;
        Optional<CategoryEntity> category = Optional.of( categoryInstance );
        when( categoryJpaRepository.findById( existentCategory ) ).thenReturn(  category );
        when( categoryNotificationsPersistenceMapper.toModelNotifications( categoryInstance ) )
                .thenReturn( new CategoryNotifications() );

        // Act
        Optional<CategoryNotifications> response = categoryRepository.findByCategory( existentCategory );

        // Assert
        assertNotNull( response );
    }

    @Test
    public void findByCategory_WhenCategoryDoesntExist_ShouldThrowCategoryNotFoundException() {
        // Arrange
        String nonExistentCategory = "Non-existent category";
        when(categoryJpaRepository.findById(nonExistentCategory)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(CategoryNotFoundException.class, () -> categoryRepository.findByCategory(nonExistentCategory));
    }
}