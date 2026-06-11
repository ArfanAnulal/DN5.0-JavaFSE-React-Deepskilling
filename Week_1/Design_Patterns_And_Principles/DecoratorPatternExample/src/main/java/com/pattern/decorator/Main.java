package com.pattern.decorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern Execution Output ===");
        Notifier emailNotifier = new EmailNotifier();
        System.out.println("1. Using Basic Notifier:");
        emailNotifier.send("Alert 1");
        
        System.out.println("\n2. Decorating with SMS:");
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        smsNotifier.send("Alert 2");
        
        System.out.println("\n3. Decorating with SMS and Slack:");
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);
        slackNotifier.send("Alert 3");
    }
}
