package com.pattern.adapter;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Adapter Pattern Execution Output ===");
        
        PayPalGateway payPalGateway = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        System.out.println("Processing payment via PayPal adapter:");
        payPalProcessor.processPayment(150.0);
        
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        System.out.println("\nProcessing payment via Stripe adapter:");
        stripeProcessor.processPayment(299.99);
    }
}
