package com.hexagonal.soccer.infrastructure.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

@Configuration
public class RabbitConfig {
    public static final String PLAYER_EXCHANGE = "player.exchange";
    public static final String PLAYER_SOCCER_QUEUE = "player.soccer.queue";

    @Bean
    Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    Queue soccerPlayerQueue() {
        return new Queue(PLAYER_SOCCER_QUEUE, true);
    }

    @Bean
    FanoutExchange playerExchange() {
        return new FanoutExchange(PLAYER_EXCHANGE, true, false);
    }

    @Bean
    Binding soccerPlayerQueueBinding() {
        return BindingBuilder.bind(soccerPlayerQueue()).to(playerExchange());
    }
}
