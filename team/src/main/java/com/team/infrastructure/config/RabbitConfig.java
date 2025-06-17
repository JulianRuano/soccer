package com.team.infrastructure.config;

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
    public static final String PLAYER_TEAM_QUEUE = "player.team.queue";

    @Bean
    Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    Queue teamPlayerQueue() {
        return new Queue(PLAYER_TEAM_QUEUE, true);
    }

    @Bean
    FanoutExchange playerExchange() {
        return new FanoutExchange(PLAYER_EXCHANGE, true, false);
    }

    @Bean
    Binding teamPlayerQueueBinding() {
        return BindingBuilder.bind(teamPlayerQueue()).to(playerExchange());
    }
}
