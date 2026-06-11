package com.testing.junit;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== JUnit Testing Component Output (Exercise 1) ===");
        BankAccount account = new BankAccount(1000.0);
        System.out.println("Initial Balance: $" + account.getBalance());
        
        System.out.println("Depositing $500...");
        account.deposit(500.0);
        System.out.println("New Balance: $" + account.getBalance());
        
        System.out.println("Withdrawing $300...");
        account.withdraw(300.0);
        System.out.println("New Balance: $" + account.getBalance());
        
        try {
            System.out.println("Attempting to withdraw $2000...");
            account.withdraw(2000.0);
        } catch (Exception e) {
            System.out.println("Exception caught successfully: " + e.getMessage());
        }
    }
}
