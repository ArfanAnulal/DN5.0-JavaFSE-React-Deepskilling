package com.pattern.observer;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Observer Pattern Execution Output ===");
        StockMarket market = new StockMarket("GOOGL", 150.0);
        
        Observer mobile = new MobileApp("PixelApp");
        Observer web = new WebApp("ChromeApp");
        
        market.registerObserver(mobile);
        market.registerObserver(web);
        
        System.out.println("Updating GOOGL price to 155.5:");
        market.setPrice(155.5);
        
        System.out.println("\nDeregistering WebApp and updating price to 160.0:");
        market.deregisterObserver(web);
        market.setPrice(160.0);
    }
}
