package com.paloit.profile.core.service.impl;

import com.paloit.card.client.CardServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ProfileServiceImplConfig {
    @Bean
    public CardServiceClient cardServiceClient(@org.springframework.beans.factory.annotation.Value("${service.card.host}") String host,
                                                                             @Value("${service.card.port}") int port) {
        return CardServiceClient.of(host, port);
    }
}
