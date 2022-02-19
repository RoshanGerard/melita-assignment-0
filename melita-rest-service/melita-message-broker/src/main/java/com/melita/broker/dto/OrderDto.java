package com.melita.broker.dto;

/**
 * Order DTO model.
 *
 * @author Roshan Bolonna
 */
public class OrderDto {

    private String orderId;
    private String name;
    private int qry;
    private double price;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQry() {
        return qry;
    }

    public void setQry(int qry) {
        this.qry = qry;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
