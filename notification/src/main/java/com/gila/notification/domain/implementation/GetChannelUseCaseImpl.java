package com.gila.notification.domain.implementation;

import com.gila.notification.application.port.inbound.GetChannelUseCase;
import com.gila.notification.application.port.outbound.ChannelPersistencePort;
import com.gila.notification.domain.models.Channel;
import com.gila.notification.domain.models.ChannelNotifications;
import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class GetChannelUseCaseImpl implements GetChannelUseCase {

    private final ChannelPersistencePort channelPersistencePort;




    @Override
    public List<ChannelNotifications> findByAll(){
return channelPersistencePort.findByAll();
    }
    @Override
   public  List<Channel> findChannels(){
        return channelPersistencePort.findChannels();
    }
/*
    @Override
    public Optional<Client> getClientByEmail(String eMail) throws ClientNotFoundException {
        return clientPersistencePort.findByEmail(eMail);


    }
*/
}
