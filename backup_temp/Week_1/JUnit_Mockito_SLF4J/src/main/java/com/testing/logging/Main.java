package com.testing.logging;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SLF4J / Logback Logging Output (Exercise 3) ===");
        LoggingService service = new LoggingService();
        
        System.out.println("Running standard logging level demo:");
        service.runDemo();
        
        System.out.println("\nRunning parameterized logging demo:");
        service.processUserAction("Benedict", "PaymentTransfer", 1002);
    }
}
