package com.junit.test.account;

public class CustomerBalance {
    private double balanceAmt;

    public CustomerBalance(double startBalance) {
        if (startBalance < 0) {
            throw new IllegalArgumentException("Initial balance amount cannot be negative.");
        }
        this.balanceAmt = startBalance;
    }

    public void addAmount(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Deposit value must be positive.");
        }
        balanceAmt += value;
    }

    public void deductAmount(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Withdrawal value must be positive.");
        }
        if (value > balanceAmt) {
            throw new IllegalStateException("Insufficient funds for withdrawal.");
        }
        balanceAmt -= value;
    }

    public double getCurrentBalance() {
        return balanceAmt;
    }
}
