package com.fontolan.springoutboxexample.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ListenerSQLServer {
    @RabbitListener(queues = "${spring.rabbitmq.queue.sqlserver.name}" )
    public void receiveMessage(Long id) {
        System.out.println("ListenerSQLServer - Subscriber: Hello, it is subscribe SQL Server. Received Product Request Update: " + id);
        // Additional processing can be added here
    }
}
