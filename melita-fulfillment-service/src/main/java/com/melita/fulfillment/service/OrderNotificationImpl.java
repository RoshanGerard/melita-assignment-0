package com.melita.fulfillment.service;

import com.melita.broker.config.MessageBrokerConfig;
import com.melita.broker.dto.OrderDto;
import com.melita.broker.dto.OrderStatusDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderNotificationImpl implements OrderNotification {

    @RabbitListener(queues = MessageBrokerConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatusDto orderStatusDto) {
        System.out.println("Message received.");
    }
}
