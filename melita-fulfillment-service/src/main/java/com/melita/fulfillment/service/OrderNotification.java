package com.melita.fulfillment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.melita.broker.dto.OrderStatusDto;

/**
 * Order notification service specification.
 *
 * @author Roshan Bolonna
 */
public interface OrderNotification {

    void consumeMessageFromQueue(OrderStatusDto orderStatusDto) throws JsonProcessingException;
}
