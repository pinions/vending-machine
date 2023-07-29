package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class BalanceTrackerTest
{
    @Test
    public void returns_different_balance_checkers_amounts()
    {
        // Arrange and Act
        BalanceTracker balanceTracker = new BalanceTracker();

        balanceTracker.setCurrentBalanceAdded(10.00);



        // Assert
        Assert.assertEquals(10.00, balanceTracker.getCurrentBalance());
        Assert.assertEquals(0.00, balanceTracker.getStartingBalance());

    }

}
