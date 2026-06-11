package com.pattern.adapter;

public class PayPalGateway {
    public void makePayment(double dollars) {
        System.out.println("Payment of $" + dollars + " processed successfully via PayPal.");
    }
}
