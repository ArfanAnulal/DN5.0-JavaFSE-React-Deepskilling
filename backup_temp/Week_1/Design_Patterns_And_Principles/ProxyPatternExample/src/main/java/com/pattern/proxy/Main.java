package com.pattern.proxy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Proxy Pattern Execution Output ===");
        Image image = new ProxyImage("test_image.jpg");
        
        System.out.println("First call to display() (Should load from server):");
        image.display();
        
        System.out.println("\nSecond call to display() (Should retrieve from cache):");
        image.display();
    }
}
