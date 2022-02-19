package com.melita.domain.service;

import com.melita.broker.dto.OrderDto;
import com.melita.broker.dto.OrderStatusDto;
import com.melita.broker.publisher.OrderPublisher;
import com.melita.domain.dto.OrderRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Order service.
 *
 * @author Roshan Bolonna
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderPublisher orderPublisher;

    @Autowired
    public OrderServiceImpl(OrderPublisher orderPublisher) {
        this.orderPublisher = orderPublisher;
    }

    @Override
    public void notifyOrderStatus(OrderRequestDto orderRequestDto) {
        orderPublisher.publishOrder(new OrderDto());
    }
}
