package com.melita.domain.service;

import com.melita.domain.dto.OrderRequestDto;
import com.melita.domain.dto.OrderResponseDto;

/**
 * Order service specification.
 *
 * @author Roshan Bolonna
 */
public interface OrderService {

    OrderResponseDto notifyOrderStatus(OrderRequestDto orderRequestDto);
}
