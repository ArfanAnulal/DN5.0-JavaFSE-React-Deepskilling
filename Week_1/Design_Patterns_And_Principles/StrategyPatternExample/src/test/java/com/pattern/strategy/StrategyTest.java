package com.pattern.strategy;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {
    @Test
    public void testCreditCardPayment() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PaymentContext context = new PaymentContext();
        PaymentStrategy cc = new CreditCardPayment("John Doe", "1234567890123456", "123", "12/28");
        context.setPaymentStrategy(cc);
        context.executePayment(250.0);

        System.setOut(System.out);
        String out = outContent.toString();
        assertTrue(out.contains("Credit Card ending with 3456"));
        assertTrue(out.contains("250.0"));
    }

    @Test
    public void testPayPalPayment() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PaymentContext context = new PaymentContext();
        PaymentStrategy pp = new PayPalPayment("john@example.com", "mypass");
        context.setPaymentStrategy(pp);
        context.executePayment(99.99);

        System.setOut(System.out);
        String out = outContent.toString();
        assertTrue(out.contains("PayPal account john@example.com"));
        assertTrue(out.contains("99.99"));
    }
}
