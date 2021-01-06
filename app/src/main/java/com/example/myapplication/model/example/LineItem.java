package com.example.myapplication.model.example;

import com.google.gson.annotations.SerializedName;

/**
 * "product_id":"5008798",
 *       "price":"5.99",
 *       "quantity":"1",
 *       "tax_lines",
 *       "tax_lines":[
 */
public class LineItem {
    @SerializedName("product_id")
    private long productId;
    @SerializedName("price")
    private double price;
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("tax_lines")
    private TaxLine[] taxLines;

    public LineItem() {
    }

    public LineItem(long productId, double price, int quantity, TaxLine[] taxLines) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.taxLines = taxLines;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TaxLine[] getTaxLines() {
        return taxLines;
    }

    public void setTaxLines(TaxLine[] taxLines) {
        this.taxLines = taxLines;
    }
}
