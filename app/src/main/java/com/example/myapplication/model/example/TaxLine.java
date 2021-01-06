package com.example.myapplication.model.example;

/**
 * "price":"5.99",
 *           "rate":"0.06",
 *           "title":"State Tax"
 */
public class TaxLine {
    private double price;
    private double rate;
    private String title;

    public TaxLine() {
    }

    public TaxLine(double price, double rate, String title) {
        this.price = price;
        this.rate = rate;
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
