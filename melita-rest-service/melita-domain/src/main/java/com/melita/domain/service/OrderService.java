package com.melita.domain.service;

import com.melita.domain.dto.OrderRequestDto;

/**
 * Order service specification.
 *
 * @author Roshan Bolonna
 */
public interface OrderService {

    void notifyOrderStatus(OrderRequestDto orderRequestDto);
}
