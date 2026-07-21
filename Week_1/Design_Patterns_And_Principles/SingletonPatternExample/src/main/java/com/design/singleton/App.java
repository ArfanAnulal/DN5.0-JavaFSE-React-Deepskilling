package com.design.singleton;

public class App {
    public static void main(String[] args) {
        System.out.println("--- Singleton Logger Demo ---");
        GlobalLogger logger1 = GlobalLogger.getInstance();
        GlobalLogger logger2 = GlobalLogger.getInstance();
        
        System.out.println("Instance 1 HashCode: " + logger1.hashCode());
        System.out.println("Instance 2 HashCode: " + logger2.hashCode());
        System.out.println("Both point to same instance? " + (logger1 == logger2));
        
        logger1.logMessage("Recording initial startup events.");
        logger2.logMessage("Shutting down services gracefully.");
    }
}
