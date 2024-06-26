package com.fontolan.springoutboxexample.configurations;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@EnableRabbit
public class RabbitMQConfig {
    private final DomainConfig domainConfig;
    @Bean
    public Queue sqlServerQueue() {
        return new Queue(domainConfig.rabbitMQQueueSQLServer, false);
    }

    @Bean
    public Queue mongoDbQueue() {
        return new Queue(domainConfig.rabbitMQQueueMongoDB, false);
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(domainConfig.rabbitMQExchangeName);
    }

    @Bean
    public Binding sqlServerBinding(Queue sqlServerQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(sqlServerQueue).to(exchange);
    }

    @Bean
    public Binding mongoDbBinding(Queue mongoDbQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(mongoDbQueue).to(exchange);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());

        return rabbitTemplate;
    }
}
