package com.melita.broker.publisher;

import com.melita.broker.dto.OrderStatusDto;

/**
 * Order publisher specification.
 *
 * @author Roshan Bolonna
 */
public interface OrderPublisher {

    String publishOrder(OrderStatusDto orderStatusDto);
}
