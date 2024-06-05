package com.gila.notification.infrastructure.adapters.outbound.persistence;

import com.gila.notification.application.port.outbound.ChannelPersistencePort;
import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.models.ChannelNotifications;
import com.gila.notification.domain.ports.ChannelRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class ChannelPersistenceAdapter implements ChannelPersistencePort {

    private final ChannelRepository channelRepository;


    @Override
    public List<ChannelNotifications> findByAll() {
        return channelRepository.findAll();
    }
    @Override
    public List<Channel> findChannels() {
        return channelRepository.findChannels();
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