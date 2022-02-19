package com.melita.domain.dto;

/**
 * Order place response DTO model.
 *
 * @author Roshan Bolonna
 */
public class OrderResponseDto {

    private String orderId;
    private String message;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}