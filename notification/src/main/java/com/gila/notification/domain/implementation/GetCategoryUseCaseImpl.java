package com.gila.notification.domain.implementation;

import com.gila.notification.application.port.inbound.GetCategoryUseCase;
import com.gila.notification.application.port.outbound.CategoryPersistencePort;
import com.gila.notification.domain.exception.CategoryNotFoundException;
import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.CategoryNotifications;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public class GetCategoryUseCaseImpl implements GetCategoryUseCase {

    private final CategoryPersistencePort categoryPersistencePort;



    @Override
    public Optional<CategoryNotifications> findByCategory(String category) {
        return Optional.ofNullable(categoryPersistencePort.getCategoryById(category)
                                           .orElseThrow(() -> new CategoryNotFoundException(String.format("Category not found [id]: %s",
                                                                                                          category))));
    }

    @Override
    public List<Category> findByAll() {
/*
        var categoriesResponse=categoryPersistencePort..stream()
                .map(categoryPersistenceMapper::toCategoryResponse)
                .toList();
        */

        return categoryPersistencePort.getClientByAll();
    }
/*
    @Override
    public Optional<Client> getClientByEmail(String eMail) throws ClientNotFoundException {
        return clientPersistencePort.findByEmail(eMail);


    }
*/
}
