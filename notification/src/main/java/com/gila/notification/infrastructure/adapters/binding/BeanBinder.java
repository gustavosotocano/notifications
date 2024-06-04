package com.gila.notification.infrastructure.adapters.binding;

import com.gila.notification.application.port.inbound.GetCategoryUseCase;


import com.gila.notification.domain.implementation.CreateNotificationUseCaseImpl;
import com.gila.notification.domain.implementation.GetCategoryUseCaseImpl;
import com.gila.notification.domain.implementation.GetChannelUseCaseImpl;
import com.gila.notification.domain.implementation.GetLogUseCaseImpl;
import com.gila.notification.domain.ports.CategoryRepository;
import com.gila.notification.domain.ports.ChannelRepository;
import com.gila.notification.domain.ports.LogRepository;
import com.gila.notification.domain.models.NotificationChannel;
import com.gila.notification.infrastructure.outbound.persistence.CategoryPersistenceAdapter;

import com.gila.notification.infrastructure.outbound.persistence.ChannelPersistenceAdapter;
import com.gila.notification.infrastructure.outbound.persistence.LogsPersistenceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class BeanBinder {


    @Bean
    public CategoryPersistenceAdapter categoryPersistenceAdapter(CategoryRepository categoryRepository) {
        return new CategoryPersistenceAdapter(categoryRepository);
    }
    @Bean
    public LogsPersistenceAdapter logsPersistenceAdapter(LogRepository logRepository) {
        return new LogsPersistenceAdapter(logRepository);
    }
    @Bean
    public ChannelPersistenceAdapter channelPersistenceAdapter(ChannelRepository channelRepository) {
        return new ChannelPersistenceAdapter(channelRepository);
    }



    @Bean
    public CreateNotificationUseCaseImpl createNotificationUseCase( GetCategoryUseCase getCategoryUseCase,
                                                                    Map<String, NotificationChannel> notificationChannels ) {
        return new CreateNotificationUseCaseImpl(getCategoryUseCase,notificationChannels);
    }

    @Bean
    public GetCategoryUseCaseImpl getCategoryUseCase(CategoryPersistenceAdapter categoryPersistenceAdapter) {
        return new GetCategoryUseCaseImpl(categoryPersistenceAdapter);
    }


    @Bean
    public GetLogUseCaseImpl getLogsUseCase(LogsPersistenceAdapter logsPersistenceAdapter) {
        return new GetLogUseCaseImpl(logsPersistenceAdapter);
    }
    @Bean
    public GetChannelUseCaseImpl getChannelUseCase(ChannelPersistenceAdapter channelPersistenceAdapter) {
        return new GetChannelUseCaseImpl(channelPersistenceAdapter);
    }

       /*
    @Bean
    public UpdateClientUseCaseImpl updateClientUseCaseImpl(ClientPersistenceAdapter clientPersistenceAdapter) {
        return new UpdateClientUseCaseImpl(clientPersistenceAdapter);
    }*/

}
