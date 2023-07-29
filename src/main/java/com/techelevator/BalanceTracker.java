package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class BalanceTracker {
    // Variables
    private int amountInput;
    private BigDecimal currentBalance = BigDecimal.valueOf(0.00);   // tracks TOTAL
    private BigDecimal startingBalance = BigDecimal.valueOf(0.00);  // resets TOTAL to 0

    // --------------  getters  -----------------
    public BigDecimal getCurrentBalance()
    {
        return currentBalance;
    }

    // ------------------  setters  ---------------------
    public void setCurrentBalanceAdded(BigDecimal balanceAdded)  // FEED MONEY
    {
        this.currentBalance = getCurrentBalance().add(balanceAdded);
    }

    public void setCurrentBalanceSubtracted(BigDecimal purchasePrice)     // subtract after each product dispense
    {
        this.currentBalance = getCurrentBalance().subtract(purchasePrice);
    }

    public void setCurrentToStartBalance()
    {
        this.currentBalance = startingBalance;
    }

}
