package com.melita.fulfillment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.melita.broker.config.MessageBrokerConfig;
import com.melita.broker.dto.OrderStatusDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Notify placed orders to fulfillment center.
 *
 * @author Roshan Bolonna
 */
@Component
public class OrderNotificationImpl implements OrderNotification {

    final Logger logger = LoggerFactory.getLogger(OrderNotificationImpl.class);
    final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = MessageBrokerConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatusDto orderStatusDto) throws JsonProcessingException {
        final String orderStatus = objectMapper.writeValueAsString(orderStatusDto);
        logger.info("****** Order received to fulfillment center. ******");
        logger.info(orderStatus);
    }
}
