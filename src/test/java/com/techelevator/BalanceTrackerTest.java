package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        InventoryManager inventoryManager = new InventoryManager();
        List<InventoryManager> inventoryList = new ArrayList<>();

        inventoryList.add(new InventoryManager("A1", "U-Chews",BigDecimal.valueOf(1.65),"Gum",5));
        inventoryList.add(new InventoryManager("B1", "Ginger Ayle",BigDecimal.valueOf(1.85),"Drink",3));
        inventoryList.add(new InventoryManager("C1", "Snykkers",BigDecimal.valueOf(4.25),"Candy",2));

        // Act
        BigDecimal dollar = BigDecimal.valueOf(1);
        BigDecimal gumDiscounted = inventoryList.get(0).getItemPrice();
        BigDecimal drinkDiscounted = inventoryList.get(1).getItemPrice();
        BigDecimal candyDiscounted = inventoryList.get(2).getItemPrice().subtract(dollar);

        // Assert
        Assert.assertEquals(gumDiscounted, balanceTracker.getDollarOff(true, 3, inventoryList.get(0)));
        Assert.assertEquals(drinkDiscounted, balanceTracker.getDollarOff(false, 4, inventoryList.get(1)));
        Assert.assertEquals(candyDiscounted, balanceTracker.getDollarOff(true, 8, inventoryList.get(2)));

    }


}
