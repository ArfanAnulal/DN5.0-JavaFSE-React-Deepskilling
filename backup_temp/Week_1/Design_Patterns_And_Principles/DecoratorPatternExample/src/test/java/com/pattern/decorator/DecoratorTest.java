package com.pattern.decorator;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTest {
    @Test
    public void testEmailOnly() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Notifier notifier = new EmailNotifier();
        notifier.send("Hello");

        System.setOut(System.out);
        String out = outContent.toString();
        assertTrue(out.contains("Email: Hello"));
        assertFalse(out.contains("SMS"));
        assertFalse(out.contains("Slack"));
    }

    @Test
    public void testEmailAndSMS() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Notifier notifier = new SMSNotifierDecorator(new EmailNotifier());
        notifier.send("Hello");

        System.setOut(System.out);
        String out = outContent.toString();
        assertTrue(out.contains("Email: Hello"));
        assertTrue(out.contains("SMS: Hello"));
        assertFalse(out.contains("Slack"));
    }

    @Test
    public void testEmailSMSAndSlack() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Notifier notifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        notifier.send("Hello");

        System.setOut(System.out);
        String out = outContent.toString();
        assertTrue(out.contains("Email: Hello"));
        assertTrue(out.contains("SMS: Hello"));
        assertTrue(out.contains("Slack Notification: Hello"));
    }
}
