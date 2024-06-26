package com.fontolan.springoutboxexample.listeners;

import com.fontolan.springoutboxexample.configurations.DomainConfig;
import com.fontolan.springoutboxexample.models.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ListenerMongo {
    private final DomainConfig domainConfig;

    public ListenerMongo(DomainConfig domainConfig) {
        this.domainConfig = domainConfig;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.mongodb.name}" )
    public void receiveMessage(Product product) {
        System.out.println("ListenerMongo - Subscriber: Hello, it is subscribe mongo. Received Product: " + product);
        // Additional processing can be added here
    }
}
