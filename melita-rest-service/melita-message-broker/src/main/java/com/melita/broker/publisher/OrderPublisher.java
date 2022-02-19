package com.melita.broker.publisher;

import com.melita.broker.dto.OrderDto;

/**
 * Order publisher specification.
 *
 * @author Roshan Bolonna
 */
public interface OrderPublisher {

    String publishOrder(OrderDto orderDto);
}
