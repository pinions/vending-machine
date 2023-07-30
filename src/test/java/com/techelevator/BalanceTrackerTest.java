package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BalanceTrackerTest
{
    @Test
    public void return_balance_added()
    {
        // Arrange
        BalanceTracker balanceTracker = new BalanceTracker();

        // Act
        balanceTracker.addCurrentBalance(BigDecimal.valueOf(10));
        BigDecimal ten = BigDecimal.valueOf(10);

        // Assert
        Assert.assertEquals(ten, balanceTracker.getCurrentBalance());
    }

    @Test
    public void return_balance_subtracted()
    {
        // Arrange
        BalanceTracker balanceTracker = new BalanceTracker();

        // Act 2
        balanceTracker.setCurrentBalance(BigDecimal.valueOf(10.00));
        balanceTracker.subtractCurrentBalance(BigDecimal.valueOf(5));
        BigDecimal five = BigDecimal.valueOf(5.00);

        // Assert 2
        Assert.assertEquals(five, balanceTracker.getCurrentBalance());
    }

    @Test
    public void return_balance_empty()
    {
        // Arrange
        BalanceTracker balanceTracker = new BalanceTracker();

        // Act 3
        balanceTracker.setCurrentBalance(BigDecimal.valueOf(0.00));
        BigDecimal zero = BigDecimal.valueOf(0.00);

        // Assert 3
        Assert.assertEquals(zero, balanceTracker.getCurrentBalance());
    }

    @Test
    public void return_current_balance()
    {
        // Arrange
        BalanceTracker balanceTracker = new BalanceTracker();

        // Act
        balanceTracker.setCurrentBalance(BigDecimal.valueOf(15));
        BigDecimal fifteen = BigDecimal.valueOf(15);

        // Assert
        Assert.assertEquals(fifteen, balanceTracker.getCurrentBalance());

    }

    @Test
    public void return_money_fed_in()
    {
        // Arrange
        BalanceTracker balanceTracker = new BalanceTracker();

        // Act
        BigDecimal twenty = BigDecimal.valueOf(20);

        // Assert
        Assert.assertEquals(twenty, balanceTracker.feedMoney("20"));

    }

    @Test
    public void return_discounted_balance_when_august()
    {
        // Arrange
        BalanceTracker balanceTracker = new BalanceTracker();
        InventoryManager inventoryItem = new InventoryManager();

        // Act
        BigDecimal gumDiscounted = BigDecimal.valueOf(items price - 1);

        // Assert
        Assert.assertEquals(gumDiscounted, balanceTracker.getDollarOff(true, 0, itemhere ));

    }


}
