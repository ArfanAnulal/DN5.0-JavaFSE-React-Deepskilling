package com.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private final String stockName;
    private double price;

    public StockMarket(String stockName, double initialPrice) {
        this.stockName = stockName;
        this.price = initialPrice;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}
