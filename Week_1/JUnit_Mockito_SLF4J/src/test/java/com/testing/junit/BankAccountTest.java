package com.testing.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        // Arrange
        account = new BankAccount(1000.0);
        System.out.println("Test setup: account initialized with $1000");
    }

    @AfterEach
    public void tearDown() {
        account = null;
        System.out.println("Test teardown complete.");
    }

    @Test
    public void testDeposit() {
        // Act
        account.deposit(500.0);
        // Assert
        assertEquals(1500.0, account.getBalance(), "Balance should reflect the deposit");
    }

    @Test
    public void testWithdraw() {
        // Act
        account.withdraw(400.0);
        // Assert
        assertEquals(600.0, account.getBalance(), "Balance should reflect the withdrawal");
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        // Assert
        assertThrows(IllegalStateException.class, () -> {
            // Act
            account.withdraw(1500.0);
        }, "Should throw exception when withdrawing more than current balance");
    }

    @Test
    public void testNegativeDeposit() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100.0);
        });
    }

    @Test
    public void testAssertions() {
        BankAccount nullAccount = null;
        assertNull(nullAccount);
        assertNotNull(account);
        assertTrue(account.getBalance() > 0);
        assertFalse(account.getBalance() < 0);
    }
}
