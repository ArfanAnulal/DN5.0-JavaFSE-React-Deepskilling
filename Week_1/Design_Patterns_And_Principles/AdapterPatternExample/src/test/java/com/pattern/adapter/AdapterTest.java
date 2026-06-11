package com.pattern.adapter;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class AdapterTest {
    @Test
    public void testPayPalAdapter() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PayPalGateway gateway = new PayPalGateway();
        PaymentProcessor processor = new PayPalAdapter(gateway);
        processor.processPayment(150.0);

        System.setOut(System.out); // reset to standard out
        assertTrue(outContent.toString().contains("PayPal"));
        assertTrue(outContent.toString().contains("150.0"));
    }

    @Test
    public void testStripeAdapter() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        StripeGateway gateway = new StripeGateway();
        PaymentProcessor processor = new StripeAdapter(gateway);
        processor.processPayment(150.0);

        System.setOut(System.out); // reset to standard out
        assertTrue(outContent.toString().contains("Stripe"));
        assertTrue(outContent.toString().contains("15000.0")); // 150 dollars = 15000 cents
    }
}
