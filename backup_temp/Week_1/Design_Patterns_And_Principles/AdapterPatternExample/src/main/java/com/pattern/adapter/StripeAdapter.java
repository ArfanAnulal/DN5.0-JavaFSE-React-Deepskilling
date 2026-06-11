package com.pattern.adapter;

public class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Stripe expects payment in cents (double cents = amount * 100)
        double cents = amount * 100.0;
        stripeGateway.chargeAmount(cents);
    }
}
