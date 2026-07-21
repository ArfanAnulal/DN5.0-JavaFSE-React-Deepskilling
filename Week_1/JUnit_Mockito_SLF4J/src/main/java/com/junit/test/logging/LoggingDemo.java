package com.junit.test.logging;

public class LoggingDemo {
    public static void main(String[] args) {
        System.out.println("=== SLF4J Logging Demonstration ===");
        AppLoggerService service = new AppLoggerService();

        // 1. Log warning
        System.out.println("\nTriggering a warning log...");
        service.performTask(null);

        // 2. Log error
        System.out.println("\nTriggering an error log...");
        service.performTask("error-trigger");
    }
}
