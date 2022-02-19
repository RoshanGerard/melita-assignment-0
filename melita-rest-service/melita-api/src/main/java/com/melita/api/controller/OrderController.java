package com.melita.api.controller;

import com.melita.domain.dto.OrderRequestDto;
import com.melita.domain.dto.OrderResponseDto;
import com.melita.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Order Rest API.
 *
 * @author Roshan Bolonna
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequestDto orderRequestDto) {
        final OrderResponseDto orderResponseDto = orderService.notifyOrderStatus(orderRequestDto);
        return new ResponseEntity(orderResponseDto, HttpStatus.OK);
    }
}
