package com.example.myapplication.model.example;

import com.google.gson.annotations.SerializedName;

/**
 *  "order_id":"1234",
 *   "created_at":"2015-01-01 00:00:00",
 *   "customer_id":"100",
 *   "line_items":[
 */
public class Order {

    @SerializedName("order_id")
    private long orderId;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("customer_id")
    private long customerId;
    @SerializedName("line_items")
    private LineItem[] lineItems;

    public Order() {
    }

    public Order(long orderId, String createdAt, long customerId, LineItem[] lineItems) {
        this.orderId = orderId;
        this.createdAt = createdAt;
        this.customerId = customerId;
        this.lineItems = lineItems;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }

    public void setLineItems(LineItem[] lineItems) {
        this.lineItems = lineItems;
    }
}
