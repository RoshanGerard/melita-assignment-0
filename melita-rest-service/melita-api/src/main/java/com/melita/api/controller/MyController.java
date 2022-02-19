package com.melita.api.controller;

import com.melita.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Order Rest API.
 *
 * @author Roshan Bolonna
 */
@RestController
@RequestMapping("/acme")
public class MyController {

    private OrderService orderService;

    @Autowired
    public MyController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        orderService.notifyOrderStatus(null);
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }
}
