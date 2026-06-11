package com.pattern.observer;

public class MobileApp implements Observer {
    private final String name;
    private double latestPrice;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double price) {
        this.latestPrice = price;
        System.out.println("MobileApp [" + name + "] notified: Stock " + stockName + " is now $" + price);
    }

    public double getLatestPrice() {
        return latestPrice;
    }
}
