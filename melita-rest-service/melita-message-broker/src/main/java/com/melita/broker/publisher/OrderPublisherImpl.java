package com.melita.broker.publisher;

import com.melita.broker.config.MessageBrokerConfig;
import com.melita.broker.dto.OrderDto;
import com.melita.broker.dto.OrderStatusDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderPublisherImpl implements OrderPublisher {

    private RabbitTemplate template;

    private OrderPublisherImpl() {}

    @Autowired
    public OrderPublisherImpl(RabbitTemplate template) {
        this.template = template;
    }

    @Override
    public String publishOrder(OrderStatusDto orderStatusDto) {
        orderStatusDto.setStatus("PROCESSING");
        orderStatusDto.setMessage("Order placed successfully");

        template.convertAndSend(MessageBrokerConfig.EXCHANGE, MessageBrokerConfig.ROUTING, orderStatusDto);

        return "order placed.";
    }
}
