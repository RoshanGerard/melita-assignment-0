package com.melita.domain.service;

import com.melita.broker.dto.OrderDto;
import com.melita.broker.dto.OrderStatusDto;
import com.melita.broker.publisher.OrderPublisher;
import com.melita.domain.dto.OrderRequestDto;
import com.melita.domain.dto.OrderResponseDto;
import com.melita.domain.engine.OrderProcessEngine;
import com.melita.domain.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Order service.
 *
 * @author Roshan Bolonna
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderPublisher orderPublisher;

    @Autowired
    public OrderServiceImpl(OrderPublisher orderPublisher) {
        this.orderPublisher = orderPublisher;
    }

    @Override
    public OrderResponseDto notifyOrderStatus(OrderRequestDto orderRequestDto) {
        final OrderProcessEngine orderProcessEngine = new OrderProcessEngine();
        final OrderResponseDto orderResponseDto = orderProcessEngine.placeOrder(orderRequestDto);
        final OrderStatusDto orderStatusDto = new OrderStatusDto();
        orderStatusDto.setOrderId(orderResponseDto.getOrderId());

        orderPublisher.publishOrder(orderStatusDto);

        return orderResponseDto;
    }
}
