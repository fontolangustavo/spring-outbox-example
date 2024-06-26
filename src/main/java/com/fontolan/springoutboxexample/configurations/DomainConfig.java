package com.fontolan.springoutboxexample.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {
    @Value("${spring.rabbitmq.queue.sqlserver.name}")
    public String rabbitMQQueueSQLServer;
    @Value("${spring.rabbitmq.queue.mongodb.name}")
    public String rabbitMQQueueMongoDB;
    @Value("${spring.rabbitmq.exchange.name}")
    public String rabbitMQExchangeName;
    @Value("${spring.datasource.url}")
    public String sqlServerUrl;
    @Value("${spring.datasource.username}")
    public String sqlServerUsername;
    @Value("${spring.datasource.password}")
    public String sqlServerPassword;
    @Value("${spring.datasource.driver-class-name}")
    public String sqlServerDriver;
}
