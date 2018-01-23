package com.example.chatapplication.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.socket.config.annotation.*;

/**
 * This is the main configuration file for the application.
 * 20.01.2018
 *
 * @author Ahmet Cetin
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.example.chatapplication.repository")
@ComponentScan(basePackages = {"com.example.chatapplication.*"})
@EnableWebSocketMessageBroker
@EnableTransactionManagement
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/sock").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}