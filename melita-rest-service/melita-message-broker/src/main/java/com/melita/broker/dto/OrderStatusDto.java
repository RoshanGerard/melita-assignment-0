package com.melita.broker.dto;

/**
 * Order Status DTO model.
 *
 * @author Roshan Bolonna
 */
public class OrderStatusDto {

    private String orderId;
    private String status;
    private String message;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
