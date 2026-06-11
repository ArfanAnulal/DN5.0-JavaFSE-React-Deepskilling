package com.pattern.observer;

public class WebApp implements Observer {
    private final String name;
    private double latestPrice;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double price) {
        this.latestPrice = price;
        System.out.println("WebApp [" + name + "] notified: Stock " + stockName + " is now $" + price);
    }

    public double getLatestPrice() {
        return latestPrice;
    }
}
