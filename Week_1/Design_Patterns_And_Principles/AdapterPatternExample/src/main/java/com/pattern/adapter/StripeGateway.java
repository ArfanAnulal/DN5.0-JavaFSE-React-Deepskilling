package com.pattern.adapter;

public class StripeGateway {
    public void chargeAmount(double cents) {
        System.out.println("Payment of " + cents + " cents charged successfully via Stripe.");
    }
}
