package com.tencent.wxcloudrun.ws;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 启用一个简单的消息代理，客户端可以订阅以 "/topic" 开头的目的地
        config.enableSimpleBroker("/topic");
        // 以 "/app" 开头的消息将被路由到消息处理方法
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个 STOMP 端点，客户端可以通过这个端点连接到 WebSocket 服务
        registry.addEndpoint("/wss").withSockJS();
    }
}