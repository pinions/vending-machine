package com.techelevator;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class BalanceTracker {
    // Variables
    private BigDecimal currentBalance = BigDecimal.valueOf(0);   // tracks TOTAL
    private final NumberFormat num = NumberFormat.getCurrencyInstance();

    // --------------  getters  -----------------
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    // ------------------  setters  ---------------------

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal addCurrentBalance(BigDecimal inputMoney) {
        currentBalance = currentBalance.add(inputMoney);
        return currentBalance;
    }


    public BigDecimal subtractCurrentBalance(BigDecimal inputMoney) {
        currentBalance = currentBalance.subtract(inputMoney);
        return currentBalance;
    }

    public BigDecimal feedMoney(String userInput) {
        try {
            BigDecimal inputMoney = new BigDecimal(userInput);
            addCurrentBalance(inputMoney);

            System.out.println("Current Money Provided: " + num.format(getCurrentBalance()));
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid input. Please input a value in whole dollars.");
        }
        return getCurrentBalance();
    }

    public BigDecimal getDollarOff(boolean isAugust, int augustCounter, InventoryManager inventoryItem) {
        BigDecimal inventoryPrice = inventoryItem.getItemPrice();
        if (augustCounter % 2 == 0 && isAugust) {
            inventoryPrice = inventoryItem.getItemPrice().subtract(BigDecimal.valueOf(1));
            System.out.println("And it's August! Enjoy a dollar off your purchase.");
        } else if (augustCounter % 2 == 1 && isAugust) {
            System.out.println("And it's August! Get a dollar off your next purchase.");
        }else {
            return inventoryPrice;
        }
        return inventoryPrice;
    }

    public BigDecimal subtractItemPriceFromBalance(boolean isAugust, int augustCounter, InventoryManager inventoryItem) {
        BigDecimal itemPrice = getDollarOff(isAugust, augustCounter, inventoryItem);
        subtractCurrentBalance(itemPrice);

        System.out.println();
        System.out.println(inventoryItem.getItemName() + " cost " + num.format(itemPrice)
                + ". You now have " + num.format(getCurrentBalance()) + ".");

        return getCurrentBalance();
    }

}