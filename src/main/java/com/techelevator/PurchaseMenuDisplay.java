package com.techelevator;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class PurchaseMenuDisplay {
    private static final String FEED_MONEY = "Feed Money";
    private static final String SELECT_PRODUCT = "Select Product";
    private static final String FINISH_TRANSACTION = "Finish Transaction";

    private static final Scanner scanner = new Scanner(System.in);

    private BalanceTracker balanceTracker = new BalanceTracker();
    private BigDecimal currentBalance = balanceTracker.getCurrentBalance();
    private ProductDisplay productDisplay = new ProductDisplay();

    public void purchaseMenu() {
        boolean stayOnPurchaseMenu = true;
        while (stayOnPurchaseMenu) {
            System.out.println();
            System.out.println("Current Money Provided: " + currentBalance);
            System.out.println();

            System.out.println("1) " + FEED_MONEY);
            System.out.println("2) " + SELECT_PRODUCT);
            System.out.println("3) " + FINISH_TRANSACTION);

            System.out.println();
            System.out.println("Please input a value 1 to 3.");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1": // feed money into machine in int
                    System.out.println();
                    System.out.println("Please input a value in whole dollars.");
                    feedMoney();
                    break;
                case "2": // purchase
                    System.out.println();
                    System.out.println("Select a product.");
                    productDisplay.productDisplay();
                    break;
                case "3": // return to main menu
                    System.out.println();
                    System.out.println("Thank you for your patronage.");
                    stayOnPurchaseMenu = false;
                    break;
                default: // catch incorrect input
                    System.out.println();
                    System.out.println("Invalid input.");
                    break;
            }
            System.out.println();
            System.out.println("Press enter to return to the purchase menu.");
            scanner.nextLine();
        }

    }

    public void feedMoney() {
        String userInput = scanner.nextLine();

        try {
            BigDecimal inputMoney = new BigDecimal(userInput);
            currentBalance = currentBalance.add(inputMoney);

            System.out.println("Current Money Provided: " + currentBalance);
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid input. Please input a value in whole dollars.");
        }
    }

}