package com.techelevator;

import java.math.BigDecimal;

public class BalanceTracker implements Accountable {
    // Variables
    private BigDecimal currentBalance = BigDecimal.valueOf(0);   // tracks TOTAL

    // --------------  getters  -----------------
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    // ------------------  setters  ---------------------

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

//    public void setCurrentToStartBalance() {
//        this.currentBalance = BigDecimal.valueOf(0);
//    }

    public BigDecimal addCurrentBalance(String userInput) {
        BigDecimal inputMoney = new BigDecimal(userInput);
        currentBalance = currentBalance.add(inputMoney);
        return currentBalance;
    }


    public BigDecimal subtractCurrentBalance(BigDecimal inputMoney) {
        currentBalance = currentBalance.subtract(inputMoney);
        return currentBalance;
    }

}