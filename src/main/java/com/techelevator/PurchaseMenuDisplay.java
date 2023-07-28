package com.techelevator;

import java.util.Scanner;

public class PurchaseMenuDisplay
{
    private static final String FEED_MONEY = "Feed Money";
    private static final String SELECT_PRODUCT = "Select Product";
    private static final String FINISH_TRANSACTION = "Finish Transaction";

    private static final Scanner scanner = new Scanner(System.in);

    public void purchaseMenu()
    {
        BalanceTracker balanceTracker = new BalanceTracker();
        MenuDisplay menuDisplay = new MenuDisplay();

        System.out.println("Current Balance: " + balanceTracker.getCurrentBalance());

        System.out.println("(1) " + FEED_MONEY);
        System.out.println("(2) " + SELECT_PRODUCT);
        System.out.println("(3) " + FINISH_TRANSACTION);

        System.out.println();
        System.out.println("Please input a number to select desired location: ");
        String userInput = scanner.nextLine();

        boolean incorrectInput = true;

        while (incorrectInput)
        {
            switch (userInput)
            {
                // feed money method
                case "1":
                    System.out.println("Deposit menu selected.");
                    System.out.println();

                    // routes to 'feed money' -> deposit
                    balanceTracker.getAmountInput();
                    balanceTracker.setCurrentBalanceAdded();

                    incorrectInput = false;
                    break;

                // select product method
                case "2":
                    System.out.println("Product selection menu selected.");
                    System.out.println();

                    // PUT ROUTE HERE


                    incorrectInput = false;
                    break;

                // finish transaction method
                case "3":
                    System.out.println("Finish Transaction selected.");
                    System.out.println();
                    System.out.println("Thank you for your purchase(s).");
                    System.out.println();
                    System.out.println("Your change back is: " + balanceTracker.getCurrentBalance());

                    // gave change set bal to 0
                    balanceTracker.setCurrentToStartBalance();

                    // REROUTE BACK TO MAIN MENU
                    menuDisplay.mainMenu();

                default:
                    System.out.println();
                    System.out.println("Please input a value 1 to 3.");
                    userInput = scanner.nextLine();
                    break;

            }

        }

    }

}
