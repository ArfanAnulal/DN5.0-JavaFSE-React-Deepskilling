package com.junit.test.account;

public class AccountDemo {
    public static void main(String[] args) {
        System.out.println("=== Customer Balance Demo ===");
        CustomerBalance account = new CustomerBalance(1500.0);
        System.out.println("Starting Balance: $" + account.getCurrentBalance());
        
        System.out.println("Depositing $700...");
        account.addAmount(700.0);
        System.out.println("Balance after deposit: $" + account.getCurrentBalance());
        
        System.out.println("Withdrawing $500...");
        account.deductAmount(500.0);
        System.out.println("Balance after withdrawal: $" + account.getCurrentBalance());
    }
}
