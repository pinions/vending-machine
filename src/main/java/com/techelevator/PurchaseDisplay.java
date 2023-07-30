package com.techelevator;

import java.math.BigDecimal;

public class PurchaseDisplay extends BalanceTracker {
    @Override
    public BigDecimal addCurrentBalance(String userInput) {
        try {
            super.addCurrentBalance(userInput);

            System.out.println("Current Money Provided: " + getCurrentBalance());
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid input. Please input a value in whole dollars.");
        }
        return getCurrentBalance();
    }
}