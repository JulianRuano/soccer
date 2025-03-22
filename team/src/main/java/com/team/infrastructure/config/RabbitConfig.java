package com.team.infrastructure.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

@Configuration
public class RabbitConfig {
    public static final String PLAYER_EXCHANGE = "player.exchange";
    public static final String PLAYER_TEAM_QUEUE = "player.team.queue";

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }  

    @Bean
    Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    FanoutExchange playerExchange() {
        return new FanoutExchange(PLAYER_EXCHANGE);
    }

    // Team Microservices
    @Bean
    Queue teamPlayerQueue() {
        return new Queue(PLAYER_TEAM_QUEUE);
    }

    @Bean
    Binding teamPlayerQueueBinding(Queue teamPlayerQueue, FanoutExchange playerExchange) {
        return BindingBuilder.bind(teamPlayerQueue).to(playerExchange);
    }

}
