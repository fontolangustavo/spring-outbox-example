package com.fontolan.springoutboxexample.listeners;

import com.fontolan.springoutboxexample.controllers.partner.request.ProductRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ListenerSQLServer {
    @RabbitListener(queues = "${spring.rabbitmq.queue.sqlserver.name}" )
    public void receiveMessage(ProductRequest productRequest) {
        System.out.println("ListenerSQLServer - Subscriber: Hello, it is subscribe SQL Server. Received Product: " + productRequest);
        // Additional processing can be added here
    }
}
