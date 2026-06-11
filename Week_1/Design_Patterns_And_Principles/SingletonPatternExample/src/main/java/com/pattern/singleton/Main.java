package com.pattern.singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Execution Output ===");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println("logger1 hash: " + logger1.hashCode());
        System.out.println("logger2 hash: " + logger2.hashCode());
        System.out.println("Are both instances equal? " + (logger1 == logger2));
        logger1.log("This is a log message from instance 1.");
        logger2.log("This is a log message from instance 2.");
    }
}
