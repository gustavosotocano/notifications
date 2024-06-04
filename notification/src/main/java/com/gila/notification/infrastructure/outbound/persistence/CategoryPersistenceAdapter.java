package com.gila.notification.infrastructure.outbound.persistence;

import com.gila.notification.application.port.outbound.CategoryPersistencePort;
import com.gila.notification.domain.models.Category;
import com.gila.notification.domain.models.CategoryNotifications;
import com.gila.notification.domain.ports.CategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {

    private final CategoryRepository categoryRepository;

    @Override
    public Optional<CategoryNotifications> getCategoryById(String category) { 
        return categoryRepository.findByCategory(category);

    }
    @Override
    public List<Category> getClientByAll() {
        return categoryRepository.findAll();
    }
/*
    @Override
    public Client saveClient(Client client) {
        return clientPersistenceMapper.toModel(clientRepository.save(clientPersistenceMapper.toEntity(client)));
    }

    @Override
    public Optional<Client> getClientById(String id) {
        return clientRepository.findById(id).map(clientPersistenceMapper::toModel);
    }

    @Override
    public  List<Client> getClientByAll() {
        return clientRepository.findAll()
                .stream().map(clientPersistenceMapper::toModel).toList();
    }

 */
/*
    @Override
    public Optional<Client> findByEmail(String email) {
        return clientRepository.findByEmail(email).map(clientPersistenceMapper::toModel);
    }
    @Override
    public Client updateClient(Client client) {

        ClientEntity existingEntity = clientRepository.findById(client.sharedKey())
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));

        existingEntity.setBussinessId(client.bussinessId());
        existingEntity.setPhone(client.phone());

        existingEntity.setStarted(client.started());
        existingEntity.setEnded(client.ended());
        existingEntity.setUpdated(new Date());
        return clientPersistenceMapper.toModel(clientRepository.save(existingEntity));
    }
*/

}