package com.pattern.strategy;

public class CreditCardPayment implements PaymentStrategy {
    private final String name;
    private final String cardNumber;
    private final String cvv;
    private final String expiryDate;

    public CreditCardPayment(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("$" + amount + " paid using Credit Card ending with " + cardNumber.substring(cardNumber.length() - 4));
    }
}
