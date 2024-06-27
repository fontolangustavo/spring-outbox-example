package com.fontolan.springoutboxexample.usecases.impl;

import com.fontolan.springoutboxexample.configurations.DomainConfig;
import com.fontolan.springoutboxexample.usecases.ProcessProductRequestUpdateUseCase;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProcessProductRequestUpdateUseCaseImpl implements ProcessProductRequestUpdateUseCase {
    private final DomainConfig domainConfig;
    private final RabbitTemplate rabbitTemplate;

    public ProcessProductRequestUpdateUseCaseImpl(DomainConfig domainConfig, RabbitTemplate rabbitTemplate) {
        this.domainConfig = domainConfig;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void process(Long id) {
        rabbitTemplate.convertAndSend(domainConfig.rabbitMQExchangeName, "", id);
    }
}
