package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BalanceTrackerTest
{
    @Test
    public void returns_different_balance_checkers_amounts()
    {
        // Arrange
        BalanceTracker balanceTracker = new BalanceTracker();

        // Act
        balanceTracker.setCurrentBalanceAdded(BigDecimal.valueOf(10));
        BigDecimal ten = BigDecimal.valueOf(10.00);

        // Assert
        Assert.assertEquals(ten, balanceTracker.getCurrentBalance());

        // Act 2
        balanceTracker.setCurrentBalanceSubtracted(BigDecimal.valueOf(5));
        BigDecimal five = BigDecimal.valueOf(5.00);

        // Assert 2
        Assert.assertEquals(five, balanceTracker.getCurrentBalance());

        // Act 3
        balanceTracker.setCurrentToStartBalance();
        BigDecimal zero = BigDecimal.valueOf(0.00);

        // Assert 3
        Assert.assertEquals(zero, balanceTracker.getCurrentBalance());

    }

}
