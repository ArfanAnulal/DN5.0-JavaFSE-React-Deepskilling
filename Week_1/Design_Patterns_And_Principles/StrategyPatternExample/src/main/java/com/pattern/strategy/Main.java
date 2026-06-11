package com.pattern.strategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern Execution Output ===");
        PaymentContext context = new PaymentContext();
        
        System.out.println("Paying via Credit Card:");
        context.setPaymentStrategy(new CreditCardPayment("Benedict", "1234567890123456", "123", "12/28"));
        context.executePayment(500.0);
        
        System.out.println("\nPaying via PayPal:");
        context.setPaymentStrategy(new PayPalPayment("benedictcm1@gmail.com", "my_password"));
        context.executePayment(120.0);
    }
}
