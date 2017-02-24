package com.bao.disruptor_gateway.config.websocket;

import com.bao.disruptor_gateway.config.properties.WebSocketEndpoints;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by bao on 2/23/17.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry
                .addEndpoint(WebSocketEndpoints.USER_ENDPOINT)
                .setAllowedOrigins("*")
                .withSockJS();
    }

}
