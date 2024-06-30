package com.fontolan.springoutboxexample.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fontolan.springoutboxexample.entities.sqlserver.ProductEntity;
import com.fontolan.springoutboxexample.entities.sqlserver.ProductRequestUpdateEntity;
import com.fontolan.springoutboxexample.enums.ProductRequestUpdateEnum;
import com.fontolan.springoutboxexample.repositories.sqlserver.ProductRepository;
import com.fontolan.springoutboxexample.repositories.sqlserver.ProductRequestUpdateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ListenerSQLServer {
    private final ProductRequestUpdateRepository productRequestUpdateRepository;
    private final ProductRepository productRepository;

    public ListenerSQLServer(
            ProductRequestUpdateRepository productRequestUpdateRepository,
            ProductRepository productRepository
    ) {
        this.productRequestUpdateRepository = productRequestUpdateRepository;
        this.productRepository = productRepository;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.sqlserver.name}" )
    public void receiveMessage(Long id)  {
        ProductRequestUpdateEntity productRequestUpdate = null;
        try {
            ObjectMapper mapper = new ObjectMapper();

            log.info("ListenerSQLServer: Received Product Request Update: " + id);

            Optional<ProductRequestUpdateEntity> productRequestUpdateEntity = productRequestUpdateRepository.findById(id);
            if (productRequestUpdateEntity.isEmpty()) {
                // what I do?
            }

            productRequestUpdate = productRequestUpdateEntity.get();

            ProductEntity productEntity = mapper.readValue(
                    productRequestUpdate.getNewData(),
                    ProductEntity.class
            );

            productRequestUpdate.setStatus(ProductRequestUpdateEnum.UPDATED.getStatus());
            productRequestUpdateRepository.save(productRequestUpdate);
            // log - sql server product request updated

            productRepository.save(productEntity);
            // log - sql server product updated

        } catch(JsonProcessingException exception) {
            log.error(exception.getMessage());

            // todo - melhorar isso
            productRequestUpdate.setStatus(ProductRequestUpdateEnum.ERROR.getStatus());
            productRequestUpdateRepository.save(productRequestUpdate);
        }
    }
}
