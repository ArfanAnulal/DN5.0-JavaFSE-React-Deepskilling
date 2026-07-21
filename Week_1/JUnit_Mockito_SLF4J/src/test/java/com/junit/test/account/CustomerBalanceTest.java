package com.junit.test.account;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerBalanceTest {
    private CustomerBalance customerAccount;

    @Before
    public void setupTestFixture() {
        // Arrange phase: Initialize test account with a baseline balance
        customerAccount = new CustomerBalance(1200.0);
        System.out.println("[JUnit 4 Setup] Initialized account with $1200.0");
    }

    @After
    public void destroyTestFixture() {
        // Teardown phase: Clean up references
        customerAccount = null;
        System.out.println("[JUnit 4 Teardown] Cleaned up account instance");
    }

    @Test
    public void testDepositLogic() {
        // Act
        customerAccount.addAmount(300.0);
        
        // Assert
        assertEquals("Deposit amount not correctly added to balance", 1500.0, customerAccount.getCurrentBalance(), 0.001);
    }

    @Test
    public void testWithdrawalLogic() {
        // Act
        customerAccount.deductAmount(400.0);
        
        // Assert
        assertEquals("Withdrawal amount not correctly deducted from balance", 800.0, customerAccount.getCurrentBalance(), 0.001);
    }

    @Test(expected = IllegalStateException.class)
    public void testWithdrawalOverdraft() {
        // Act & Assert
        customerAccount.deductAmount(2000.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDepositRestriction() {
        // Act & Assert
        customerAccount.addAmount(-10.0);
    }

    @Test
    public void testVariousJUnitAssertions() {
        CustomerBalance nullReference = null;
        
        // Exercise 3: Demonstrating JUnit assertion validations
        assertNull(nullReference);
        assertNotNull(customerAccount);
        assertTrue(customerAccount.getCurrentBalance() > 0);
        assertFalse(customerAccount.getCurrentBalance() < 0);
    }
}
