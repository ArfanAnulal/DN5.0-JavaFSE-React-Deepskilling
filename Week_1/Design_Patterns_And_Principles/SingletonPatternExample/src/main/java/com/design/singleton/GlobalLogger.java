package com.design.singleton;

public class GlobalLogger {
    private static volatile GlobalLogger uniqueInstance;

    private GlobalLogger() {
        // Prevent reflection/direct instantiation
    }

    public static GlobalLogger getInstance() {
        if (uniqueInstance == null) {
            synchronized (GlobalLogger.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new GlobalLogger();
                }
            }
        }
        return uniqueInstance;
    }

    public void logMessage(String msg) {
        System.out.println("[AppLog] " + msg);
    }
}
