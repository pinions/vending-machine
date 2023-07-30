package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class BalanceTracker {
    // Variables
    private BigDecimal inputMoney;
    private BigDecimal currentBalance = BigDecimal.valueOf(0.00);   // tracks TOTAL
    private BigDecimal startingBalance = BigDecimal.valueOf(0.00);  // resets TOTAL to 0

    // --------------  getters  -----------------
    public BigDecimal getCurrentBalance()
    {
        return currentBalance;
    }

    // ------------------  setters  ---------------------

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

//    public void setCurrentBalanceAdded(BigDecimal balanceAdded)  // FEED MONEY
//    {
//        this.currentBalance = currentBalance.add(balanceAdded);
//    }
//
//    public void setCurrentBalanceSubtracted(BigDecimal purchasePrice)     // subtract after each product dispense
//    {
//        this.currentBalance = currentBalance.subtract(purchasePrice);
//    }

    public void setCurrentToStartBalance()
    {
        this.currentBalance = startingBalance;
    }

    public BigDecimal addCurrentBalance(BigDecimal inputMoney) {
        return currentBalance.add(inputMoney);
    }

    public BigDecimal subtractCurrentBalance(BigDecimal inputMoney) {
        return currentBalance.subtract(inputMoney);
    }

}
